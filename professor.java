import java.util.ArrayList;

public class professor extends user {

    private ArrayList<prof_course> current = new ArrayList<>();
    private ArrayList<prof_course> completed = new ArrayList<>();

    private String name;

    public professor(String ID, String pass) {
        super(ID, pass);
        String[] parts = ID.split("\\d+");
        if (parts.length == 0) {
            this.name = "Prof.Unknown"; // Default value if no alphabet is found
        } else {
            this.name = "Prof." + parts[0];
        }
    }

    public void view_schedule() {
        for (int i = 0; i < current.size(); i++) {
            System.out.printf("Course: %s   Timings: %s   Office hourse: %s  Location: %s\n",
                    current.get(i).get_title(),
                    current.get(i).get_time(), current.get(i).get_offhr(), current.get(i).get_classloc());
        }
    }

    public void view_courses() {
        if (current.isEmpty()) {
            System.out.println("You hav not been assigned any course");
            return;
        }
        for (prof_course mycourse : current) {
            mycourse.give_det();
        }
    }

    @Override
    public void get_details() {
        System.out.printf("ID: %s\nPassword: %s\nContact number: %s\n", this.id, this.password, this.contactnum);
        System.out.printf("Current courses: ");
        this.printCourseCodes(current);
        System.out.println();
    }

    public void printCourseCodes(ArrayList<prof_course> list) {
        for (prof_course course : list) {
            System.out.printf("%s ", course.code);
        }
    }

    public void addcurrent(prof_course course) {
        this.current.add(course);
    }

    public ArrayList<prof_course> getcurrent() {
        return this.current;
    }

    public void update_course_show_stud(int val) {
        String choice = takeinp.strinp("Enter course code: ");
        boolean found = false;
        for (prof_course course : current) {
            if (course.code.equals(choice)) {

                if (val == 1) {
                    updatecourse.update_course(course);
                } else {
                    course.printStudlist();
                }
                found = true;
                break;

            }

        }
        if (!found) {
            System.out.println("Course not found");
        }
    }

    public String getname() {
        return name;
    }

    public void givegrade() {
        String choice = takeinp.strinp("Enter course code: ");
        String stdid = takeinp.strinp("Enter student id: ");
        String grade = takeinp.strinp("Enter grade: ");
        if (!GradeToGPA.gradelist.contains(grade)) {
            System.out.println("Please enter a valid upper case grade [A+, A, A-, B, B-, C, C-, F]");
            return;
        }
        for (prof_course course : current) {
            if (course.code.equals(choice)) {
                for (student stud : course.getstudlist()) {
                    if (stud.id.equals(stdid)) {
                        for (stud_course stdcr : stud.getcurretnlist()) {
                            if (course.code.equals(stdcr.code)) {
                                stdcr.setgrade(grade);
                                // stud.addtocomplete(stdcr);
                                System.out.println("Grade updated!");
                                return;
                            }
                        }
                    }
                }
                System.out.println("Student ID not found");
                return;
            }
        }
        System.out.println("Course not found");
        return;
    }

    public void finishsem() {
        this.completed.addAll(current);
        this.current.clear();
        mapcourse.finishsem();
    }

    public void show_feedback() {
        for (prof_course prcr : this.completed) {
            System.out.printf("%s:\n", prcr.code);
            prcr.get_feedback();
        }
    }

    public ArrayList<prof_course> getcompleted() {
        return this.completed;
    }

    public void assign_ta() {
        String code = takeinp.strinp("Enter course code: ");
        String id = takeinp.strinp("Enter student ID: ");
        for (prof_course prcr : this.current) {
            if (code.equals(prcr.code)) {
                for (student stud : userlist.getstudentlist()) {
                    if (id.equals(stud.id)) {
                        if (stud.get_ista()) {
                            System.out.println("This student is already a TA");
                            return;
                        }
                        for (stud_course stcr : stud.getcompletedlist()) {
                            if (code.equals(stcr.code)) {
                                teaching_assnt newta = new teaching_assnt(this, code, stud);
                                prcr.add_ta(newta);
                                stud.set_ista(true);
                                System.out.println("TA assigned successfully!");
                                return;
                            }
                        }
                        System.out.printf("The student has not completed %s\n", code);
                        return;
                    }
                }
                System.out.println("The given student ID doesn't  exist");
                return;
            }
        }
        System.out.println("Course not found");
        return;
    }

    public void display_ta() {
        String code = takeinp.strinp("Enter course code: ");
        boolean found = false;
        for (prof_course prcr : this.current) {
            if (code.equals(prcr.code)) {
                found = true;
                if (prcr.get_ta_list().isEmpty()) {
                    System.out.println("No TA found");
                    return;
                }
                for (teaching_assnt ta : prcr.get_ta_list()) {
                    ta.get_details();
                }
            }
        }
        if (!found) {
            System.out.println("Course code not found");
        }
    }
}
