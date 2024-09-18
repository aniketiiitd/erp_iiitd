public class updatecourse {

    public static void update_course(prof_course original) {

        System.out.printf(
                "You can update the following:\n1. Enrollment limit\n2. Syllabus\n3. Timings\n4. Prerequisites\n5. Office hours\n6. Credits\n");

        int choice = takeinp.intinp("Enter choice[1/2/3/4/5/6]: ");

        switch (choice) {

            case 1:
                original.set_enrol_lim(takeinp.intinp("Enter updated enrollment limit: "));
                break;

            case 2:
                original.syllabus = takeinp.strinp("Enter updated syllabus: ");
                mapcourse.changesyll(original.code, original.syllabus);
                break;

            case 3:
                original.timings = takeinp.strinp("Enter updated timings: ");
                break;

            case 4:
                original.prereq = takeinp.strinp("Enter updated prerequisites: ");
                mapcourse.changepreq(original.code, original.prereq);
                break;

            case 5:
                original.office_hr = takeinp.strinp("Enter updated office hours: ");
                break;

            case 6:
                original.credits = takeinp.intinp("Enter updated number of credits: ");
                break;

            default:
                System.out.println("Invalid choice. Please select a number between 1 and 6.");
                break;
        }

        original.update_stud_course(0);
    }
}
