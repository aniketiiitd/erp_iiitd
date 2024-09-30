import java.util.ArrayList;
import java.util.Iterator;

public class add_drop {

    public static void addcourse(student stud) throws AddDropDeadlinePassedException, CourseFullException {

        if (!student.getaddrop()) {
            throw new AddDropDeadlinePassedException("Add Drop Period over\n");
        }
        int cursem = stud.getcurrentsem();
        int curcred = stud.getcurrentcredits();
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

                for (prof_course prcr : mapcourse.getprof(code).getcurrent()) {
                    if (prcr.get_num_enr() + 1 > prcr.getenlm()) {
                        throw new CourseFullException("Course if full\n");
                    }
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
                inc_enr_num(choice);
            } else if (stud.preq_satisfied(choice)) {
                stud.addcurretnlist(askedfor);
                stud.setcurrentcredits(curcred + askedfor.credits);
                System.out.println("Course registered!");
                inc_enr_num(choice);
                for (prof_course prcr : mapcourse.getprof(choice).getcurrent()) {
                    if (prcr.code.equals(choice)) {
                        prcr.set_num_enr(1);
                        return;
                    }
                }
            } else {
                System.out.printf("Prerequisite %s isn't fullfilled\n", mapcourse.getpreq(choice));
            }
        } else {
            System.out.println("Credit limit (20) exceeded");
        }

    }

    public static void dropcourse(student stud) throws AddDropDeadlinePassedException {

        if (!student.getaddrop()) {
            throw new AddDropDeadlinePassedException("Add Drop Period over\n");
        }
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
                                prcr.set_num_enr(1);
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

    private static void inc_enr_num(String choice) {
        for (prof_course prcr : mapcourse.getprof(choice).getcurrent()) {
            if (prcr.code.equals(choice)) {
                prcr.set_num_enr(0);
                // System.out.println(prcr.get_num_enr());
                return;
            }
        }
    }

}