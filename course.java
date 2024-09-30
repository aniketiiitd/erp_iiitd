
public abstract class course {

    protected int credits;
    protected String code;
    protected String title;
    protected String prereq;
    protected String timings;
    protected String office_hr;
    protected String syllabus;
    protected String class_loc;

    public abstract void give_det();

    public String get_time() {
        return this.timings;
    }

    public String get_title() {
        return this.title;
    }

    public String get_offhr() {
        return this.office_hr;
    }

    public String get_classloc()
    {
        return this.class_loc;
    }
    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null || getClass() != obj.getClass())
    // return false;
    // course course = (course) obj;
    // return Objects.equals(code, course.code);
    // }

    // @Override
    // public int hashCode() {
    // return Objects.hash(code);
    // }

}
