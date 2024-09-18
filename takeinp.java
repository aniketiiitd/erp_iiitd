import java.util.Scanner;

public class takeinp {
    private static final Scanner scanner = new Scanner(System.in);

    public static int intinp(String prompt) {
        System.out.print(prompt); // Use print instead of printf to avoid adding a new line
        int val = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left after nextInt()
        return val;
    }

    public static String strinp(String prompt) {
        System.out.print(prompt); // Use print instead of printf to avoid adding a new line
        return scanner.nextLine();
    }
}
