import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeToGPA {

    public static Map<String, Integer> gradeMap = new HashMap<>();
    public static ArrayList<String> gradelist = new ArrayList<>(
            Arrays.asList("A+", "A", "A-", "B", "B-", "C", "C-", "F"));
    static {
        gradeMap.put("A+", 10);
        gradeMap.put("A", 10);
        gradeMap.put("A-", 9);
        gradeMap.put("B", 8);
        gradeMap.put("B-", 7);
        gradeMap.put("C", 6);
        gradeMap.put("C-", 5);
        gradeMap.put("F", 0);
    }
}