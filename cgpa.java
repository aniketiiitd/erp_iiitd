import java.util.ArrayList;

public class cgpa implements gpa {

    @Override
    public void givegpa(student stud) {
        ArrayList<stud_course> completed = stud.getcompletedlist();
        if (completed.isEmpty()) {
            System.out.println("No courses completed yet");
            return;
        }
        float cgpa = 0;
        for (stud_course course : completed) {
            cgpa += GradeToGPA.gradeMap.get(course.getgrade());
        }
        cgpa /= completed.size();
        System.out.printf("CGPA : %.2f\n", cgpa);
        System.out.printf("(CGPA is calculated for first %d semesters only)\n", stud.getcurrentsem() - 1);

    }

}
