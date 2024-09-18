import java.util.ArrayList;

public class professor extends user {

    private ArrayList<prof_course> current = new ArrayList<>();

    private String name;

    public professor(String ID, String pass) {
        super(ID, pass);
        String[] parts = ID.split("\\d+");
        this.name = "Prof." + parts[0];
    }

    public void view_schedule() {
        for (int i = 0; i < current.size(); i++) {
            System.out.printf("Course: %s   Timings: %s   Office hourse: %s  Location: %s\n",
                    current.get(i).get_title(),
                    current.get(i).get_time(), current.get(i).get_offhr(), current.get(i).get_classloc());
        }
    }

    public void view_courses() {
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
            }
        }
        System.out.println("Either course or student not found");
        return;
    }

    public void finishsem() {
        this.current.clear();
        mapcourse.finishsem();
    }

}
