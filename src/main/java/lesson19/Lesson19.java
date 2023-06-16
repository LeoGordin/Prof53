package lesson19;


import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


import static java.util.Arrays.*;

public class Lesson19 {
    public static void main(String[] args) {
        List<String> strings = asList("10", "20", "1", "10", "15", "50", "25");

        // только элементы 10
        System.out.println(strings.stream().filter(string -> string.equals("10")) // промежуточная
                .toList() // терминальная
        );

        System.out.println(strings.stream().skip(3).toList());

        System.out.println(strings.stream().skip(2).limit(4).toList());

        System.out.println(strings.stream().distinct().toList());

        System.out.println(strings.stream().map(Integer::parseInt).distinct().peek(e -> System.out.println("element is " + e)).map(i -> i * 3).toList());

        System.out.println(strings.stream().sorted().toList());

        System.out.println(strings.stream().sorted(Comparator.reverseOrder()).toList());

        List<List<String>> listList = asList(asList("One", "Two", "Three"), List.of("Four"), asList("Five", "Six"));

        System.out.println(listList.stream().flatMap(Collection::stream).toList());

        // терминальные операции
        // findFirst
        // Optional - класс который представляет собой либо
        // значение либо отсутствие значения

        System.out.println(strings.stream().filter(s -> s.contains("7")).findFirst().orElse("No such element"));

        strings.forEach(System.out::println);

        // allMatch(Predicate<T>)
        // anyMatch(Predicate<T>)

        System.out.println(strings.stream().anyMatch(s -> s.contains("5")));

        System.out.println(strings.stream().allMatch(s -> s.contains("1")));

        System.out.println(strings.stream().noneMatch("8"::contains));

        System.out.println(
                // min //max
                strings.stream().max(Comparator.naturalOrder()).get());

        //reduce

        int[] digits = {2, 7, 3};
        System.out.println(stream(digits).reduce(Integer::sum).getAsInt());

        System.out.println(stream(digits).reduce((i, j) -> i * j).getAsInt());

        System.out.println(strings.stream().mapToInt(Integer::parseInt).reduce(Integer::sum).getAsInt());


        strings.stream().reduce((s, s2) -> s + ", " + s2).ifPresent(System.out::println);

        //collect()
        //toList() - в список
        //toCollection() - в коллекцию
        //toSet() - в набор
        //collect(groupingBy()) - в map

        System.out.println(strings.stream().collect(Collectors.groupingBy(String::length)));

        System.out.println(strings.stream().collect(Collectors.groupingBy(s -> Integer.parseInt(s) % 5 == 0)));

        // toMap

        System.out.println(strings.stream().distinct().collect(Collectors.toMap(Function.identity(),
//                                s -> s, // ключ
                String::length //значение
        )));

    }
}