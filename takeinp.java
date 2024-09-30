import java.util.InputMismatchException;
import java.util.Scanner;

public class takeinp {
    private static final Scanner scanner = new Scanner(System.in);

    public static int intinp(String prompt) {
        int val = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            try {
                val = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
        scanner.nextLine(); 
        return val;
    }

    public static String strinp(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}

