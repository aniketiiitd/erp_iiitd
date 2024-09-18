import java.util.ArrayList;

public class courselist {

    private static ArrayList<ArrayList<String>> coursecodelist = new ArrayList<>();

    public static void populate_list() {

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("CSE101");
        list1.add("ECE101");
        list1.add("DES101");
        list1.add("MTH101");
        list1.add("SSH101");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("CSE201");
        list2.add("CSE102");
        list2.add("MTH201");
        list2.add("SSH201");
        list2.add("BIO101");
        list2.add("SG101");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("MTH301");
        list3.add("CSE202");
        list3.add("CSE301");
        list3.add("BIO201");
        list3.add("BIO202");

        // Add the inner lists to the outer ArrayList
        coursecodelist.add(list1);
        coursecodelist.add(list2);
        coursecodelist.add(list3);

        while (coursecodelist.size() <= 5) {
            coursecodelist.add(new ArrayList<String>());
        }

    }

    public static void displaycourses(int sem) {
        String profname;
        for (String code : coursecodelist.get(sem - 1)) {
            professor prof = mapcourse.getprof(code);
            if (prof == null) {
                profname = "Professor not assgined";
            } else {
                profname = prof.getname();
            }
            System.out.printf("Course code: %s, Course title: %s, Professor: %s, Credits: %d, Prerequisites: %s\n",
                    code, mapcourse.gettitle(code), profname, 4, mapcourse.getpreq(code));
        }
    }

    public static ArrayList<ArrayList<String>> getlist() {
        return coursecodelist;
    }

    public static int maxsem() {
        // return coursecodelist.size();
        return 3;
    }

    public static boolean course_exist(String choice) {
        for (int i = 0; i < courselist.maxsem(); i++) {
            for (String code : coursecodelist.get(i)) {
                if (choice.equals(code)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void add_drop(String code, int sem, int choice) {
        if (choice == 0) {
            coursecodelist.get(sem - 1).add(code);
            System.out.println("Course added!");
        } else {
            if (coursecodelist.get(sem - 1).contains(code)) {
                coursecodelist.get(sem - 1).remove(code);
                System.out.println("Course removes!");

            } else {
                System.out.printf("Course code %s not found in sem %d\n", code, sem);
            }
        }
    }
}
