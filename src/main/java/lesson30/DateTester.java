package lesson30;

/*
    Date - считается на настоящий момент устаревшим - нет временных зон
    Calendar - чуть лучше чем Date - удобные методы добавления
    LocalDate + LocalDateTime - все что нужно для работы с датой и временем без временных зон
    ZonedDateTime - + временные зоны + точность наносекунды
 */


import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTester {
    public static void main(String[] args) {
        // позволяет определить дату с точностью до милисекунд
        // хранит время в милисекундах от 1 января 1970 года - "эпоха"
        Date current = new Date(); // текушая дата и время
        System.out.println(current);
        System.out.println(current.getTime()); // милисекудны с эпохи
        Date d = new Date(1234567890L); // из милисекунд
        Date d1 = new Date(2004, 0, 10); // месяцы считаются с 0
        System.out.println(d.before(current)); // сравнение дат между собой

        System.out.printf("%tY\n", current);
        System.out.printf("%tm\n", current);
        System.out.printf("%td\n", current);
        System.out.printf("%tY-%tm-%td\n", current, current, current);

        Locale fr = new Locale("fr", "CA");
        System.out.printf(fr, "%tc", current);

    }
}
