import java.util.ArrayList;

public class prof_course extends course {

    private int enrol_lim;
    private ArrayList<student> studlist = new ArrayList<>();
    private int num_enr = 0;
    private ArrayList<Integer> int_feedback = new ArrayList<>();
    private ArrayList<String> str_feedback = new ArrayList<>();
    private ArrayList<teaching_assnt> ta_list = new ArrayList<>();

    public prof_course(int enrol_lim, int credits, String code, String title, String prereq,
            String timings,
            String office_hr, String loc, String syllabus) {
        this.enrol_lim = enrol_lim;
        this.credits = credits;
        this.code = code;
        this.title = title;
        this.prereq = prereq;
        this.timings = timings;
        this.office_hr = office_hr;
        this.syllabus = syllabus;
        this.class_loc = loc;
    }

    @Override
    public void give_det() {
        System.out.printf(
                "Title: %s\nCode: %s\nCredits: %d\nEnrollment limit: %d\nPrerequisites: %s\nSyllabus: %s\nTimings: %s\nOffice_hours: %s\n",
                this.title, this.code, this.credits, this.enrol_lim, this.prereq, this.syllabus, this.timings,
                this.office_hr);
    }

    public void set_enrol_lim(int el) {
        this.enrol_lim = el;
    }

    public int getenlm() {
        return this.enrol_lim;
    }

    public void addstd(student stud) {
        this.studlist.add(stud);
    }

    public void update_stud_course(int val) {

        for (student stud : this.studlist) {
            for (stud_course course : stud.getcurretnlist()) {

                if (this.code.equals(course.code)) {
                    stud.setcurrentcredits(stud.getcurrentcredits() + (this.credits - course.credits));
                    course.syllabus = this.syllabus;
                    course.timings = this.timings;
                    course.prereq = this.prereq;
                    course.office_hr = this.syllabus;
                    course.credits = this.credits;
                    course.class_loc = this.class_loc;
                    // System.out.printf("profcr: %d, studcr: %d\n", this.credits, course.credits);
                    break;

                }

            }

        }
        if (val == 0) {
            System.out.println("Course details updated!");
        }

    }

    public void printStudlist() {
        // return studlist;
        for (student stud : this.studlist) {
            for (stud_course stdcr : stud.getcurretnlist()) {
                if (stdcr.code.equals(this.code)) {
                    System.out.printf("student id: %s   contact num: %s  grade: %s\n", stud.id, stud.contactnum,
                            stdcr.getgrade());
                    break;
                }
            }
        }
    }

    public ArrayList<student> getstudlist() {
        return this.studlist;
    }

    public void rmstd(student stud) {
        this.studlist.remove(stud);
    }

    public int get_num_enr() {
        return this.num_enr;
    }

    public void set_num_enr(int val) {
        if (val == 0) {
            this.num_enr++;
        } else {
            this.num_enr--;
        }

    }

    public void set_feedback_str(String feedback)

    {
        this.str_feedback.add(feedback);
    }

    public void set_feedback_int(int feedback)

    {
        this.int_feedback.add(feedback);
    }

    public void get_feedback() {

        if (!this.str_feedback.isEmpty()) {
            System.out.print("Reviews: ");
            System.out.println(this.str_feedback);
        }

        if (!this.int_feedback.isEmpty()) {
            System.out.print("Ratings: ");
            System.out.println(this.int_feedback);
        }
    }

    public void add_ta(teaching_assnt TA) {
        this.ta_list.add(TA);
    }

    public ArrayList<teaching_assnt> get_ta_list() {
        return this.ta_list;
    }
}
