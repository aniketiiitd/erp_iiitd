import java.util.ArrayList;
import java.util.Arrays;

public class mkcourse {

    private static ArrayList<String> time = new ArrayList<>(Arrays.asList("Monday: 8:30-10:00", "Tuesday: 9:30-11:00",
            "Wednesday: 8:30-10:00", "Thursday: 9:30-11:00",
            "Friday: 8:30-10:00", "Monday: 13:30-15:00", "Tuesday: 14:30-16:00", "Wednesday: 13:30-15:00",
            "Thursday: 14:30-16:00", "Friday: 13:30-15:00"));
    private static ArrayList<String> location = new ArrayList<>(
            Arrays.asList("C102", "C101", "C201", "B003", "A006", "A01"));
    private static int num = 0;

    public static prof_course mk_prof_course(professor prof, String code) {
        int cred = 4;
        if (code.equals("SG101")) {
            cred = 2;
        }
        prof_course prcr = new prof_course(100, cred, code, mapcourse.gettitle(code), mapcourse.getpreq(code),
                time.get(num % 10),
                time.get((num + 1) % 10), location.get(num % 6),
                mapcourse.getsyllabus(code));
        prof.addcurrent(prcr);
        mapcourse.add_codetoprof(code, prof);
        num++;
        System.out.println("Professor assigned successfully!");
        return prcr;
    }

    public static stud_course mk_stud_course(student stud, String code) {
        stud_course stcr = new stud_course(stud.getcurrentsem(), num, mapcourse.getprof(code), code,
                mapcourse.gettitle(code), mapcourse.getpreq(code), code, code, mapcourse.getsyllabus(code));
        professor prof = mapcourse.getprof(code);
        for (prof_course prcr : prof.getcurrent()) {
            if (prcr.code.equals(stcr.code)) {
                prcr.addstd(stud);
                // prcr.update_stud_course(1);
                stcr.class_loc = prcr.class_loc;
                stcr.credits = prcr.credits;
                stcr.timings = prcr.timings;
                break;

            }
        }
        return stcr;
    }
}
