public class admin {

    private static final String password = "admin@IIITD";

    public void viewcourses() {
        for (int i = 0; i < courselist.maxsem(); i++) {
            System.out.printf("For sem : %d\n", i + 1);
            courselist.displaycourses(i + 1);
        }
    }

    public void view_stdrecord() {
        String id = takeinp.strinp("Enter student ID: ");
        if (usermap.stud_exist(id)) {
            usermap.getstd(id).get_details();
        } else {
            System.out.println("Student not found");
        }
    }

    public void add_drop_course() {
        int choice = takeinp.intinp("Do you want to add/drop course [0/1]: ");
        String code = takeinp.strinp("Enter course code: ");
        if (choice == 0) {
            int sem = takeinp.intinp("Enter semester in which the course is to be offered: ");
            courselist.add_drop(code, sem, choice);
        } else if (choice == 1) {
            int sem = takeinp.intinp("Enter semester in which the course is being currently offered: ");
            courselist.add_drop(code, sem, choice);
        } else {
            System.out.println("Invalid choice");
        }
    }

    public void add_rm_stud() {
        int choice = takeinp.intinp("Do you want to add/remove a student [0/1]: ");
        if (choice == 0) {
            student newstud = mkuser.mkstud();
            // userlist.addstdlist(newstud);
        } else if (choice == 1) {
            String id = takeinp.strinp("Enter student id: ");
            userlist.remove_stud(id);
        }
    }

    public void add_rm_prof() {
        int choice = takeinp.intinp("Do you want to add/remove a professor [0/1]: ");
        if (choice == 0) {
            professor newprof = mkuser.mkprof();
            // userlist.addproflist(newprof);
        } else if (choice == 1) {
            String id = takeinp.strinp("Enter professor id: ");
            userlist.remove_prof(id);
        }
    }

    public void resolvecomplain() {
        boolean found = false;

        int code = takeinp.intinp("Enter complaint code: ");
        for (complaint comp : complaintlist.getlist()) {
            if (code == comp.getcode()) {
                comp.resolve();
                System.out.println("Complaint resolved!");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Complaint not found");
        }

    }

    public void giveprofcourse() {
        String choice = takeinp.strinp("Enter course code: ");
        String profid = takeinp.strinp("Enter professor ID: ");
        if (courselist.course_exist(choice) && usermap.prof_exist(profid)) {
            if (mapcourse.getprof(choice) != null && mapcourse.getprof(choice).equals(usermap.getprof(profid))) {
                System.out.printf("Professor %s has been already assigned %s\n", profid, choice);
                return;
            }
            prof_course newprofcourse = mkcourse.mk_prof_course(usermap.getprof(profid), choice);

        } else {
            System.out.println("Either the course or professor doesn't exist");
        }
    }

    public void update_std_details() {
        String id = takeinp.strinp("Enter student ID: ");
        if (usermap.stud_exist(id)) {
            System.out.println("1. To change password\n2. To change contact number\n");
            int choice = takeinp.intinp("Enter choice: ");
            student std = usermap.getstd(id);
            std.edit_details(std, id, choice);
        } else {
            System.out.println("Student not found");
        }

    }

    public void finishsem() {
        if (userlist.getstudentlist().isEmpty() || userlist.getproflist().isEmpty()) {
            System.out.println("No student/professor found");
            return;
        }
        for (student std : userlist.getstudentlist()) {
            if (!std.can_semend()) {
                System.out.println("Result not declared for all studetns");
                return;
            }
        }
        for (student stud : userlist.getstudentlist()) {
            stud.finishsem();
        }
        for (professor prof : userlist.getproflist()) {
            prof.finishsem();
        }

        System.out.println("Sem finished, all records updated!");
    }
    // public void filter_complaints()
    // {

    // }

    public void resolve_comp() {
        int choice = takeinp.intinp("Enter complaint ID: ");
        for (complaint comp : complaintlist.getlist()) {
            if (choice == comp.getcode()) {
                comp.resolve();
                System.out.println("Complaint is Resolved!");
                return;
            }
        }
        System.out.println("Complaint id not found");
    }

}
