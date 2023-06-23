package lesson22;

import java.util.Date;

public class PrintTester {
    //        System.out - поток вывода
//        System.in - поток ввода
//        System.err - поток вывода ошибок
    public static void main(String[] args) {
        System.err.println("It's a standard error output stream!");

        System.out.printf("it's a %b, years %d, salary %f \n", false, 15, 23002.34);

        System.out.printf("it's a %b, years %d, salary %8.2f \n", false, 15, 23002.34);

        System.out.printf("pi is %.8f \n", Math.PI);

        Date date = new Date();
        System.out.printf("hours: %tH, minutes: %tM, seconds: %tS \n", date, date, date);

        System.out.printf("hours: %1$tH, minutes: %1$tM, seconds: %1$tS \n", date);
    }
}
