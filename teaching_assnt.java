public class teaching_assnt extends student {

    private professor prof;
    private String course_code;
    private String id;

    public teaching_assnt(professor proff, String code, student stud) {
        this.prof = proff;
        this.course_code = code;
        this.id = stud.id + "_" + code;
    }

    @Override
    public void get_details() {
        System.out.printf("ID: %s, Course code: %s, Professor: %s\n", this.id, this.course_code, this.prof.getname());
    }

    public String getid() {
        return this.id;
    }

    public void give_grade() {
        String stdid = takeinp.strinp("Enter student id: ");
        String grade = takeinp.strinp("Enter grade: ");
        if (!GradeToGPA.gradelist.contains(grade)) {
            System.out.println("Please enter a valid upper case grade [A+, A, A-, B, B-, C, C-, F]");
            return;
        }
        for (student stud : userlist.getstudentlist()) {
            if (stud.id.equals(stdid)) {
                for (stud_course stdcr : stud.getcurretnlist()) {
                    if (this.course_code.equals(stdcr.code)) {
                        if (stdcr.getgrade() == null) {
                            System.out.println("Professor has not assigned a grade");
                            return;
                        }
                        stdcr.setgrade(grade);
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
