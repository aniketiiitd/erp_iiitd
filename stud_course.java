public class stud_course extends course {

    private int sem;
    // private boolean graded = false;
    private professor proff;
    private String grade = null;

    public stud_course(int sem, int credits, professor prof, String code, String title, String prereq, String timings,
            String office_hr, String syllabus) {
        this.sem = sem;
        this.credits = credits;
        this.proff = prof;
        this.code = code;
        this.title = title;
        this.prereq = prereq;
        this.timings = timings;
        this.office_hr = office_hr;
        this.syllabus = syllabus;
    }

    @Override
    public void give_det() {
        System.out.printf(
                "Title: %s\nProfessor: %s\n,Code: %d\nCredits: %d\nPrerequisites: %s\nSyllabus: %s\nTimings: %s\nOffice_hours\n",
                this.title, this.proff, this.code, this.credits, this.prereq, this.syllabus, this.timings,
                this.office_hr);
    }

    public professor getprof() {
        return this.proff;
    }

    public String getgrade() {
        return this.grade;
    }

    public void setgrade(String grd) {
        this.grade = grd;
    }

    public int getsem() {
        return this.sem;
    }
}
    