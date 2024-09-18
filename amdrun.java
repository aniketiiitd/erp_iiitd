public class amdrun implements usr_run {

    @Override
    public void displayoptions() {
        System.out.printf(
                "1. Display course catalog\n2. Add/Drop course\n3. View student records\n4. Update Student records\n5. Assign professor to course\n6. Manage complaints\n7. Finish Semester\n8. Log out\n");
    }

    @Override
    public void enter() {
        admin loggedadmin = mkuser.mkadmin();
        System.out.printf("\n\tHello Admin\n");
        System.out.println("How can we help you?");
        this.displayoptions();
        int choice = takeinp.intinp("Enter choice[1/2/.../8]: ");
        while (true) {
            if (choice == 1) {
                loggedadmin.viewcourses();
            } else if (choice == 2) {
                loggedadmin.add_drop_course();
            } else if (choice == 3) {
                loggedadmin.view_stdrecord();
            } else if (choice == 4) {
                loggedadmin.update_std_details();
            } else if (choice == 5) {
                loggedadmin.giveprofcourse();
            } else if (choice == 6) {
                this.managecomplain(loggedadmin);
            } else if (choice == 7) {
                loggedadmin.finishsem();
            } else if (choice == 8) {
                return;
            } else {
                System.out.println("Invalid choice");
            }

            this.displayoptions();
            choice = takeinp.intinp("Enter choice[1/2/.../8]: ");
        }
    }

    public void managecomplain(admin loggedadmin) {
        System.out.printf("\n\tComplaint Manager\n");
        System.out.printf("1.Display all complaints\n2.Filter complaints\n3.Resolve complains\n4.Go back\n");
        int opt = takeinp.intinp("Enter choice[1/2/3/4]: ");
        while (true) {
            if (opt == 1) {
                complaintlist.displaycomplaints(0);
            } else if (opt == 2) {
                int fil = takeinp.intinp("Filter by pending or resolved?[1/2]: ");
                complaintlist.displaycomplaints(fil);
            } else if (opt == 3) {
                loggedadmin.resolve_comp();
            } else if (opt == 4) {
                return;
            } else {
                System.out.println("Invalid choice");
            }
            System.out
                    .printf("1.Display all complaints\n2.Filter complaints\n3.Resolve complains\n4.Go back\n");
            opt = takeinp.intinp("Enter choice[1/2/3/4]: ");
        }
    }
}
