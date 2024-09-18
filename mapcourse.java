import java.util.HashMap;

public class mapcourse {

    private static HashMap<String, String> codetotitle = new HashMap<>();
    private static HashMap<String, String> codetosyllabus = new HashMap<>();
    private static HashMap<String, String> codetopreq = new HashMap<>();
    private static HashMap<String, professor> codetoprof = new HashMap<>();
    // private static HashMap<String, Integer> codetosem = new HashMap<>();

    public static void fillmap() {
        // SEM 1
        codetotitle.put("CSE101", "Introduction to Programming");
        codetosyllabus.put("CSE101", "Python");
        codetotitle.put("DES101", "Introduction to Human Computer Interaction");
        codetosyllabus.put("DES101", "Good Gesign");
        codetotitle.put("ECE101", "Digital Circuits");
        codetosyllabus.put("ECE101", "Circuits");
        codetotitle.put("MTH101", "Linear Algebra");
        codetosyllabus.put("MTH101", "RREF matrices");
        codetotitle.put("SSH101", "Communication Skills");
        codetosyllabus.put("SSH101", "Effective Communication");

        // SEM 2
        codetotitle.put("CSE201", "Data Structures and Algorithms");
        codetosyllabus.put("CSE201", "C++, Data Structures");
        codetopreq.put("CSE201", "CSE101");

        codetotitle.put("CSE102", "Computer Organization");
        codetosyllabus.put("CSE102", "Assembly,Pipelining");
        codetopreq.put("CSE102", "ECE101");

        codetotitle.put("MTH201", "Probability and Statistics");
        codetosyllabus.put("MTH201", "Probability theory");

        codetotitle.put("SSH201", "Critical Thinking and Reading in Social Sciences");
        codetosyllabus.put("SSH201", "Argument analysis");

        codetotitle.put("BIO101", "Foundations of Biology");
        codetosyllabus.put("BIO101", "Basic theoretical and quantitative biology");

        codetotitle.put("SG101","Self Growth");
        codetosyllabus.put("SG101", "Chess");
        // SEM 3
        codetotitle.put("CSE202", "Advanced Programing");
        codetosyllabus.put("CSE202", "Java, OOP's");
        codetopreq.put("CSE202", "CSE201");

        codetotitle.put("CSE301", "Operating Systems");
        codetosyllabus.put("CSE301", "Virtualization, Concurrency");

        codetotitle.put("MTH301", "Multivariate Calculus");
        codetosyllabus.put("MTH301", "Differentiation, Integration");
        codetopreq.put("MTH301", "MTH201");

        codetotitle.put("BIO201", "Genetics and Molecular Biology");
        codetosyllabus.put("BIO201", "Principles of genetics");

        codetotitle.put("BIO202", "Cell Biology and Biochemistry");
        codetosyllabus.put("BIO202", "Basic cell biology and biochemistry");
        codetopreq.put("BIO202", "BIO101");
    }

    public static String gettitle(String code) {
        return codetotitle.get(code);
    }

    public static String getsyllabus(String code) {
        return codetosyllabus.get(code);
    }

    public static void add_codetoprof(String code, professor proff) {
        codetoprof.put(code, proff);
    }

    public static professor getprof(String code) {
        return codetoprof.get(code);
    }

    public static boolean isprof(String code) {
        return codetoprof.containsKey(code);
    }

    public static String getpreq(String code) {
        return codetopreq.get(code);
    }

    public static void changesyll(String code, String syll) {
        codetosyllabus.replace(code, syll);
    }

    public static void changepreq(String code, String preq) {
        codetopreq.replace(code, preq);
    }

    public static void finishsem()
    {
        codetoprof.clear();
    }

}