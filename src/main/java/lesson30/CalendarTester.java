package lesson30;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTester {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance(); //текущая дата + время
        calendar.set(Calendar.DAY_OF_MONTH, 3); //установить поле
        calendar.add(Calendar.MONTH, 4); //добавим 4 месяца

        System.out.println(calendar.getTime()); // получение даты

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime())
        );

        Date d = myFormat.parse("1984-03-24 05:00:23");
        System.out.println(d);
        System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)); // какой день недели у даты


    }
}
