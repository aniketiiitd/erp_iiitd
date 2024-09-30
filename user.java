public class user {

    protected String id;
    protected String password;
    protected String contactnum = "1234567890";
    // protected ArrayList<course> courses;

    public user(String ID, String pass) {
        this.id = ID; // takeinp.strinp("Enter your ID"); take inp through other class which
                      // verifies if user exists or not
        this.password = pass; // takeinp.strinp("Create a new password");

    }

    public user() {
    }

    public void get_details() {
        System.out.printf("ID: %s\nPassword: %s\nContact number: %d\n", this.id, this.password, this.contactnum);
    }

}
