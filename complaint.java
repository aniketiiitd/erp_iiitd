public class complaint {

    private student stud;
    private String matter;
    private String status;
    private int code;
    private static int givecode = 1;

    public complaint(student stud) {
        this.code = givecode;
        givecode++;
        this.stud = stud;
        this.matter = takeinp.strinp("Enter the complaint: ");
        this.status = "pending";
        complaintlist.addcomplaint(this);
        System.out.println("Complaint Registered!");
    }

    public String getmatter() {
        return this.matter;
    }

    public void resolve() {
        this.status = "resolved";
    }

    public String getstatus() {
        return this.status;
    }

    public String getstud() {
        return this.stud.id;
    }

    public int getcode() {
        return this.code;
    }
}
