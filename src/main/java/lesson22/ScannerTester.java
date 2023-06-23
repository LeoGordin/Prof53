package lesson22;
import java.util.Scanner;

public class ScannerTester {
    public static void main(String[] args) {
        System.out.println("Enter whole number and press Enter");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Enter whole number and press Enter");
        int k = scanner.nextInt();
        System.out.printf("Sum of two numbers is %d \n", n + k);


        System.out.println("Enter number with floating point and press Enter");

        if (scanner.hasNextDouble()) {
            double salary = scanner.nextDouble();
            System.out.println("Salary: " + salary);
        }

        System.out.println("Enter your name and press Enter");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Your name is " + name);
    }
}
