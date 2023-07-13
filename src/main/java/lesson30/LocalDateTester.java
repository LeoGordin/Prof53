package lesson30;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class LocalDateTester {
    public static void main(String[] args) {

        LocalDate now = LocalDate.now(); //дата сейчас

        LocalDate nov10 = LocalDate.of(2005, Month.NOVEMBER, 10);

        System.out.println(nov10);

        now = now.plusDays(5).minusMonths(2);

        now = now
                .withMonth(4)
                .with(ChronoField.HOUR_OF_DAY, 7);

        LocalDateTime time  = LocalDateTime.now();

        System.out.println(
                time.format(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                )
        );


    }
}
