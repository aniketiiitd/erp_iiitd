import java.util.HashMap;

public class usermap {
    private static HashMap<String, student> studmap = new HashMap<>();
    private static HashMap<String, professor> profmap = new HashMap<>();
    private static HashMap<String, String> idtopass = new HashMap<>();

    public static boolean stud_exist(String id) {
        return studmap.containsKey(id);
    }

    public static boolean prof_exist(String id) {
        return profmap.containsKey(id);
    }

    public static student getstd(String id) {
        return studmap.get(id);
    }

    public static professor getprof(String id) {
        return profmap.get(id);
    }

    public static String getpass(String id) {
        return idtopass.get(id);
    }

    public static void delstd(String id) {
        studmap.remove(id);
    }

    public static void delprof(String id) {
        profmap.remove(id);
    }

    public static void delpass(String id) {
        idtopass.remove(id);
    }

    public static void addstud(String id, student stud) {
        studmap.put(id, stud);
    }

    public static void addprof(String id, professor prof) {
        //System.out.println("prof added");
        profmap.put(id, prof);
    }

    public static void addpass(String id, String pass) {
        idtopass.put(id, pass);
    }

    public static void changepass(String id, String pass) {
        idtopass.replace(id, pass);
    }

    public static void changestdid(String id, student stud) {
        studmap.replace(id, stud);  
    }
}
