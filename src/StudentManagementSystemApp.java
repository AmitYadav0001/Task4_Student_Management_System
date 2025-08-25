import java.util.Scanner;

public class StudentManagementSystemApp {
    public static void main(String[] args) {

        StudentManagementSystem sms = new StudentManagementSystem();
        System.out.println("===*===*===*===*===*-STUDENT--MANAGEMENT--SYSTEM-*===*===*===*===*===");
        Scanner sc = new Scanner(System.in);
        System.out.println("STUDENT-MANAGEMENT-MENU");

        while (true) {
            System.out.println("1. Adding New Student");
            System.out.println("2. Search Student");
            System.out.println("3. Editing Existing Student");
            System.out.println("4. Display All Student List");
            System.out.println("5. Remove Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice : ");

            int choose = sc.nextInt();

            switch (choose) {
                case 1 -> sms.addStudent();
                case 2 -> sms.searchStudent();
                case 3 -> sms.editStudent();
                case 4 -> sms.displayAllStudent();
                case 5 -> sms.removeStudent();
                case 6 -> {
                    System.out.println("----Exiting program----");
                    System.out.println("----ThankYou-----");

                    System.exit(0);
                }
                default -> System.out.println("Invalid choice ....");
            }

        }
    }
}