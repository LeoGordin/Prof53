package lesson22;

import java.util.Scanner;

public class ScannerTester {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("введите целое число и нажмите 'ввод'");
        int n = scanner.nextInt(); // считаем целое с консоли
        System.out.println("введите целое число и нажмите 'ввод'");
        int k = scanner.nextInt();
        System.out.println("результат сложения: " + (n+k));

        System.out.println("введите число с плавающей точкой и нажмите 'ввод'");
        if(scanner.hasNextDouble())
        {
            double salary = scanner.nextDouble();
            System.out.println("число " + salary);
        }

        System.out.println("введите имя и нажмите 'ввод'");
        scanner.nextLine(); // считываем перевод строки после числа
        String name = scanner.nextLine();
        System.out.println("Вы ввели имя " + name);


    }
}
