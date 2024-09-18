import java.util.ArrayList;

public class userlist {

    private static ArrayList<student> stdlist = new ArrayList<>();
    private static ArrayList<professor> proflist = new ArrayList<>();

    public static void displaystudents() {
        System.out.println(stdlist);
    }

    public static ArrayList<student> getstudentlist() {
        return stdlist;
    }

    public static ArrayList<professor> getproflist() {
        return proflist;
    }

    public static void displayprofs() {
        System.out.println(proflist);
    }

    public static void addstdlist(student stud) {
        stdlist.add(stud);
    }

    public static void addproflist(professor prof) {
        proflist.add(prof);
    }

    public static void remove_stud(String stud_id) {

        if (usermap.stud_exist(stud_id)) {
            stdlist.remove(usermap.getstd(stud_id));
            usermap.delstd(stud_id);
            System.out.println("Student account removed!");
        }

        else {
            System.out.println("Student id not found");
        }

    }

    public static void remove_prof(String prof_id) {

        if (usermap.prof_exist(prof_id)) {
            proflist.remove(usermap.getprof(prof_id));
            usermap.delprof(prof_id);
            System.out.println("Professor account removed!");
        }

        else {
            System.out.println("Professor id not found");
        }

    }

}
