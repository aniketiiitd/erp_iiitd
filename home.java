//import java.util.Scanner;

public class home {

    public static void displaychoices() {
        System.out.println("\nLogin as:\n1.Student\n2.Professor\n3.Administrator\n4.exit");
    }

    public static void enter() {
        System.out.println("\n\tWelcome to IIITD");
        displaychoices();
        int choice = takeinp.intinp("Enter choice [1/2/3/4]: ");
        while (choice != 4) {
            if (choice == 1) {
                stdrun stdr = new stdrun();
                stdr.enter();
            } else if (choice == 2) {
                profrun prdr = new profrun();
                prdr.enter();
            } else if (choice == 3) {
                amdrun addr = new amdrun();
                addr.enter();
            } else if (choice == 4) {
                return;
            } else {
                System.out.println("Invalid choice");
            }
            displaychoices();
            choice = takeinp.intinp("Enter choice [1/2/3/4]: ");
        }

    }
}
