import java.util.ArrayList;
import java.util.Iterator;

public class student extends user {

    private int current_sem = 1;
    private int current_credits = 0;
    private ArrayList<stud_course> completed = new ArrayList<>();
    private ArrayList<stud_course> current = new ArrayList<>();
    private ArrayList<String> backlog = new ArrayList<>();
    private complaint myComplaint = null;

    public student(String ID, String pass) {
        super(ID, pass);
    }

    public void view_schedule() {
        for (stud_course course : current) {
            System.out.printf("Course: %s   Timings: %s   Location: %s   Professor name: %s\n", course.title,
                    course.timings, course.class_loc, course.getprof().getname());
        }
    }

    public void printCourseCodes(ArrayList<stud_course> list) {
        for (stud_course course : list) {
            System.out.printf("%s ", course.code);
        }
    }

    @Override
    public void get_details() {
        System.out.printf("ID: %s\nPassword: %s\nContact number: %s\nCurrent sem: %d\nCredits gained: %d\n", this.id,
                this.password, this.contactnum, this.current_sem, this.current_credits);
        System.out.printf("Completed courses: ");
        this.printCourseCodes(completed);
        System.out.println();
        System.out.printf("Current courses: ");
        this.printCourseCodes(current);
        System.out.println();

    }

    public ArrayList<stud_course> getcurretnlist() {
        return this.current;
    }

    public ArrayList<String> getbackloglist() {
        return this.backlog;
    }

    public void addcurretnlist(stud_course course) {
        this.current.add(course);
    }

    public void rmcurretnlist(stud_course course) {
        this.current.remove(course);
    }

    public ArrayList<stud_course> getcompletedlist() {
        return this.completed;
    }

    public boolean preq_satisfied(String code) {
        for (stud_course compl : this.completed) {
            if (mapcourse.getpreq(code) == null || mapcourse.getpreq(code).equals(compl.code)) {
                return true;
            }
        }
        return false;
    }

    public int getcurrentsem() {
        return this.current_sem;
    }

    public int getcurrentcredits() {
        return this.current_credits;
    }

    public void setcurrentcredits(int val) {
        this.current_credits = val;
    }

    public void getSGPA() {
        sgpa mysg = new sgpa();
        mysg.givegpa(this);
    }

    public boolean can_semend() {

        for (stud_course course : this.current) {
            if (course.getgrade() == null) {
                return false;
            }
        }
        return true;
    }

    public void finishsem() {
        Iterator<stud_course> iterator = this.current.iterator();
        while (iterator.hasNext()) {
            stud_course course = iterator.next();
            if (course.getgrade().equals("F")) {
                this.backlog.add(course.code);
                this.current_credits -= course.credits;
            } else {
                this.completed.add(course);

            }
            iterator.remove();
        }
        this.current_sem++;
    }

    public void getCGPA() {
        cgpa mycg = new cgpa();
        mycg.givegpa(this);
    }

    public void lodgecomplaint() {
        myComplaint = new complaint(this);
    }

    public void complaintstatus() {
        if (myComplaint == null) {
            System.out.println("You have not lodged any complaint");
            return;
        }
        System.out.println(myComplaint.getstatus());
    }

    public void edit_details(student stud, String id, int choice) {
        if (choice == 1) {
            stud.password = takeinp.strinp("Enter new password: ");
            usermap.changepass(id, stud.password);
            System.out.println("Details updated!");
        }
        // else if (choice == 2) {
        // stud.id = takeinp.strinp("Enter new ID: ");
        // // student std = usermap.getstd(id);
        // usermap.changestdid(stud.id, stud);
        // usermap.changepass(stud.id, stud.password);
        // System.out.println("Details updated!");
        // }

        else if (choice == 2) {
            stud.contactnum = takeinp.strinp("Enter new contact number: ");
            System.out.println("Details updated!");
        } else {
            System.out.println("Invalid choice");
        }

    }
}
