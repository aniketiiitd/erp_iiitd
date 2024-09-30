public class profrun implements usr_run {

    @Override
    public void displayoptions() {
        System.out.printf(
                "1. Display courses\n2. Update course details\n3. View Schedule\n4. View enrolled students\n5. Give grade\n6. View course feedback\n7. Get Teaching Assistants\n8. Show Teaching Assistants\n9. View personal info\n10. Log out\n");
    }

    @Override
    public void enter() {
        professor loggedprof = mkuser.mkprof();
        System.out.printf("\n\tHello %s\n", loggedprof.getname());
        System.out.println("How can we help you?");
        this.displayoptions();
        int choice = takeinp.intinp("Enter choice[1/2/.../10]: ");
        while (true) {
            if (choice == 1) {
                loggedprof.view_courses();
            } else if (choice == 2) {
                loggedprof.update_course_show_stud(1);
            } else if (choice == 3) {
                loggedprof.view_schedule();
            } else if (choice == 4) {
                loggedprof.update_course_show_stud(0);
            } else if (choice == 5) {
                loggedprof.givegrade();
            } else if (choice == 6) {
                loggedprof.show_feedback();
            } else if (choice == 7) {
                loggedprof.assign_ta();
            } else if (choice == 8) {
                loggedprof.display_ta();
            } else if (choice == 9) {
                loggedprof.get_details();
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
