package lesson31;

import lesson29.Car;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Repeat {
    // напишите функцию которая вернет из списка коллекцию из элементов,
    // номера которых передаются в виде varargs

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("407", "Peugeot", 15_500),
                new Car("Ram", "Dodge", 23_000),
                new Car("Matiz", "Reno", 17_400)
        );
        System.out.println(getElements(cars, 0, 2));

        LocalDateTime epoch = LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0);
        System.out.println(epoch);

        LocalDateTime bd = LocalDateTime.of(1991, Month.FEBRUARY, 7, 12, 0);
        System.out.println(bd);

        String birthday = bd.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRANCE));
        System.out.println(birthday);

        DateTimeFormatter french = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRENCH);

        System.out.println(birthday.formatted(french));

        String forInstant = "2023-07-13T20:34:00.00Z";

        Instant instant = Instant.parse(forInstant);

        System.out.println(instant);

        System.out.println(
                instant.atZone(ZoneId.of("Pacific/Honolulu"))
        );

    }



    public static <T> Collection<T> getElements(List<T> list, int... elements) {
        // elements доступен это как массив
        // elements.length
        List <T> result = new ArrayList<>();
        for (int i: elements) {
            result.add(list.get(i));
        }
        return result;
    }
}
