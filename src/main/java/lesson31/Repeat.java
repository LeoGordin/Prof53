package lesson31;

import lesson2.crossword.C;
import lesson29.Car;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Repeat {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("407", "Peugeot", 15_500),
                new Car("Ram", "Dodge", 23_000),
                new Car("Matiz", "Reno", 17_400)
        );
        System.out.println(
                getElements(cars, 0, 2) // 407 + Matiz
        );

        // создайте LocalDateTime с какой-нибудь датой, например с днем рождения
        LocalDateTime epoch = LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0);
        System.out.println(epoch);
        // 01 january 1970 - выведите дату в таком формате, посмотрите javadoc на DateTimeFormatter
        // или предыдущее занятие
        String date = epoch.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        System.out.println(date);
        // выведите то-же самое по-французски
        Locale locale = new Locale("fr", "CA");
        DateTimeFormatter french = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRENCH);
        System.out.println(epoch.format(french));

        // создайте момент из строки
        // "2023-07-13T19:34:00.00Z"
        Instant instant = Instant.parse("2023-07-13T19:34:00.00Z"); // создайте из строки
        System.out.println(instant);

        // переведите этот момент времени в временную зону
        // Pacific/Honolulu
        System.out.println(
                instant.atZone(ZoneId.of("Pacific/Honolulu")) // 2023-07-13T09:34-10:00[Pacific/Honolulu]
        );



    }

    // напишите функцию которая вернет из списка коллекцию из элементов,
    // номера которых передаются в виде varargs
    public static <T> Collection<T> getElements(List<T> list, int ... elements)
    {
        List<T> result = new ArrayList<>();
        // elements доступен это как массив
        // elements.length
        for(int i : elements)
        {
            result.add(list.get(i));
        }
        return result;
    }

}
