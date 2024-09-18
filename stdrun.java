public class stdrun implements usr_run {

    @Override
    public void displayoptions() {
        System.out.printf(
                "1. Display courses\n2. Add course\n3. View Schedule\n4. get SGPA\n5. get CGPA\n6. Drop course\n7. Lodge complaint\n8. View complaint Status\n9. View personal info\n10. Log out\n");
    }

    @Override
    public void enter() {
        student loggedstd = mkuser.mkstud();
        System.out.printf("\n\tHello %s\n", loggedstd.id);
        System.out.println("How can we help you?");
        this.displayoptions();
        int choice = takeinp.intinp("Enter choice[1/2/.../10]: ");
        while (true) {
            if (choice == 1) {
                int sem = takeinp.intinp("Enter semester [1/2/3]: ");
                courselist.displaycourses(sem);
            } else if (choice == 2) {
                add_drop.addcourse(loggedstd);
            } else if (choice == 3) {
                loggedstd.view_schedule();
            } else if (choice == 4) {
                loggedstd.getSGPA(); // sgpa for recenlty completed semester
            } else if (choice == 5) {
                loggedstd.getCGPA();
            } else if (choice == 6) {
                add_drop.dropcourse(loggedstd);
            } else if (choice == 7) {
                loggedstd.lodgecomplaint();
            } else if (choice == 8) {
                loggedstd.complaintstatus();
            } else if (choice == 9) {
                loggedstd.get_details();
            } else if (choice == 10) {
                return;
            } else {
                System.out.println("Invalid choice");
            }

            this.displayoptions();
            choice = takeinp.intinp("Enter choice[1/2/.../10]: ");
        }
    }
}
