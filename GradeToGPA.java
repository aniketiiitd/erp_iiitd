import java.util.HashMap;
import java.util.Map;

public class GradeToGPA {
    // Corrected map declaration to use Integer
    public static Map<String, Integer> gradeMap = new HashMap<>();

    // Static block to initialize the map
    static {
        gradeMap.put("A", 10);
        gradeMap.put("A-", 9);
        gradeMap.put("B", 8);
        gradeMap.put("B-", 7);
        gradeMap.put("C", 6);
        gradeMap.put("C-", 5);
        gradeMap.put("F", 0);
    }
}