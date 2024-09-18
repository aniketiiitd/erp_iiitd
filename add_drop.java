import java.util.ArrayList;
import java.util.Iterator;

public class add_drop {

    public static void addcourse(student stud) {
        int cursem = stud.getcurrentsem();
        // if (courselist.maxsem() < cursem) {
        // System.out.println("Courses not available for your semester");
        // return;
        // }
        int curcred = stud.getcurrentcredits();
        // courselist.displaycourses(cursem);
        ArrayList<String> available = (courselist.getlist().get(cursem - 1));
        available.addAll(stud.getbackloglist());
        System.out.println("Choose from the following courses:");
        System.out.println(available);
        String choice = takeinp.strinp("Enter course code: ");
        boolean found = false;
        stud_course askedfor = null;
        for (String code : available) {
            if (code.equals(choice)) {
                if (!mapcourse.isprof(code)) {
                    System.out.println("No professor has been assigned to this course");
                    return;
                }
                askedfor = mkcourse.mk_stud_course(stud, choice);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Course code not found for your semester");
            return;
        }
        for (stud_course curr : stud.getcurretnlist()) {
            if (choice.equals(curr.code)) {
                System.out.printf("You have already registered for %s\n", choice);
                return;
            }
        }
        if (curcred + askedfor.credits <= 20) {
            if (cursem == 1) {
                stud.addcurretnlist(askedfor);
                stud.setcurrentcredits(curcred + askedfor.credits);
                System.out.println("Course registered!");
            } else if (stud.preq_satisfied(choice)) {
                stud.addcurretnlist(askedfor);
                stud.setcurrentcredits(curcred + askedfor.credits);
                System.out.println("Course registered!");
            } else {
                System.out.printf("Prerequisite %s isn't fullfilled\n", mapcourse.getpreq(choice));
            }
        } else {
            System.out.println("Credit limit (20) exceeded");
        }

    }


    public static void dropcourse(student stud) {
        stud.printCourseCodes(stud.getcurretnlist());
        System.out.println();
        String choice = takeinp.strinp("Enter course code: ");
        boolean removed = false;

        Iterator<stud_course> courseIterator = stud.getcurretnlist().iterator();

        while (courseIterator.hasNext()) {
            stud_course course = courseIterator.next();
            if (course.code.equals(choice)) {
                courseIterator.remove(); // Safe removal using Iterator
                stud.setcurrentcredits(stud.getcurrentcredits() - course.credits);

                professor prof = course.getprof();
                Iterator<prof_course> prcrIterator = prof.getcurrent().iterator();

                while (prcrIterator.hasNext()) {
                    prof_course prcr = prcrIterator.next();
                    if (choice.equals(prcr.code)) {
                        Iterator<student> crstdIterator = prcr.getstudlist().iterator();

                        while (crstdIterator.hasNext()) {
                            student crstd = crstdIterator.next();
                            if (crstd.equals(stud)) {
                                crstdIterator.remove(); // Safe removal
                                System.out.println("Course dropped!");
                                removed = true;
                                return; // Exit inner loop
                            }
                        }

                    }
                }

            }
        }

        if (!removed) {
            System.out.println("Course code not found");
        }
    }

}