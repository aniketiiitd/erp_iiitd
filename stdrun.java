public class stdrun implements usr_run {

    @Override
    public void displayoptions() {
        System.out.printf(
                "1. Display courses\n2. Add course\n3. View Schedule\n4. get SGPA\n5. get CGPA\n6. Drop course\n7. Lodge complaint\n8. View complaint Status\n9. Give course feedback\n10. Enter TA menu\n11. View personal info\n12. Log out\n");
    }

    @Override
    public void enter() {
        student loggedstd = mkuser.mkstud();
        System.out.printf("\n\tHello %s\n", loggedstd.id);
        System.out.println("How can we help you?");
        this.displayoptions();
        int choice = takeinp.intinp("Enter choice[1/2/.../12]: ");
        while (true) {
            if (choice == 1) {
                int sem = takeinp.intinp("Enter semester [1/2/3]: ");
                courselist.displaycourses(sem);
            } else if (choice == 2) {
                boolean valid = false;
                while (!valid) {
                    try {
                        add_drop.addcourse(loggedstd);

                    } catch (AddDropDeadlinePassedException e) {
                        System.out.println(e);

                    } catch (CourseFullException e) {
                        System.out.println(e);

                    } finally {
                        valid = true;
                    }
                }

            } else if (choice == 3) {
                loggedstd.view_schedule();
            } else if (choice == 4) {
                loggedstd.getSGPA(); // sgpa for recenlty completed semester
            } else if (choice == 5) {
                loggedstd.getCGPA();
            } else if (choice == 6) {
                boolean valid = false;
                while (!valid) {
                    try {
                        add_drop.dropcourse(loggedstd);

                    } catch (AddDropDeadlinePassedException e) {
                        System.out.println(e);
                    } finally {
                        valid = true;
                    }
                }
            } else if (choice == 7) {
                loggedstd.lodgecomplaint();
            } else if (choice == 8) {
                loggedstd.complaintstatus();
            } else if (choice == 9) {
                loggedstd.give_feedback();
            } else if (choice == 10) {
                if (loggedstd.get_ista()) {
                    boolean valid = false;
                    while (!valid) {
                        for (professor prof : userlist.getproflist()) {
                            for (prof_course prcr : prof.getcurrent()) {
                                for (teaching_assnt ta : prcr.get_ta_list()) {
                                    if ((loggedstd.id + "_" + prcr.code).equals(ta.getid())) {
                                        manageta(ta);
                                        valid = true;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("You are not a TA");
                }
            } else if (choice == 11) {
                loggedstd.get_details();
            } else if (choice == 12) {
                return;
            } else {
                System.out.println("Invalid choice");
            }

            this.displayoptions();
            choice = takeinp.intinp("Enter choice[1/2/.../12]: ");
        }
    }

    private void manageta(teaching_assnt loggedta) {
        System.out.printf("\n\tTA menu\n");
        System.out.printf("1.Give Grade\n2.Get your info\n3. Go back\n");
        int opt = takeinp.intinp("Enter choice[1/2/3]: ");
        while (true) {
            if (opt == 1) {
                loggedta.give_grade();
            } else if (opt == 2) {
                loggedta.get_details();
            } else if (opt == 3) {
                return;
            } else {
                System.out.println("Invalid choice");
            }
            System.out.printf("1.Give Grade\n2.Get your info\n3. Go back\n");
            opt = takeinp.intinp("Enter choice[1/2/3]: ");
        }
    }
}
