import java.util.ArrayList;

public class sgpa implements gpa {

    @Override
    public void givegpa(student stud) {
        float sgpa = 0;
        ArrayList<stud_course> current = stud.getcurretnlist();
        if (current.isEmpty()) {
            System.out.println("You have not registered for any courses yet");
            return;
        }
        int count = current.size();
        for (stud_course course : current) {
            if (course.getgrade() == null) {
                System.out.println("The grading of all the courses has not been done yet");
                return;
            } else {
                if (course.getgrade().equals("F")) {
                    System.out.printf("You have failed in %s\n", course.title);
                    count--;
                }
                sgpa += GradeToGPA.gradeMap.get(course.getgrade());
            }
        }

        sgpa /= count;
        System.out.printf("SGPA : %.2f\n", sgpa);
        if (count < current.size()) {
            System.out.printf("(SGPA is calculated for %d courses only)\n", count);
        }
        // return sgpa;
    }
}
