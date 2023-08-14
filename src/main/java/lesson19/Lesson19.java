package lesson19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class Lesson19 {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("10", "20", "1", "10", "15", "50", "25");

        // только элементы 10
        System.out.println(
                strings.stream()
                        .filter(string -> string.equals("10")) // промежуточная
                        .collect(Collectors.toList()) // терминальная
        );

        System.out.println(
                strings.stream()
                        .filter(string -> string.equals("10")) // промежуточная
                        .count() // терминальная
        );

        // пропустить 3 первых элемента
        System.out.println(
                strings.stream().skip(3).collect(Collectors.toList())
        );

        // первые 3 элемента limit(3)

        // покажите элементы с 3 по 6
        System.out.println(
                strings.stream().limit(6).skip(3).collect(Collectors.toList())
        );

        // List<String> strings = Arrays.asList("10", "20", "1", "10", "15", "50", "25");
        // distinct - не повторяющиеся элементы
        System.out.println(
                strings.stream().distinct().collect(Collectors.toList())
        );

        // преобразуйте элементы в Integer, сделайте distinct и умножте на 3
        System.out.println(
                strings.stream()
                        .map(Integer::parseInt)
                        .distinct()
                        .peek(e -> System.out.println("element is " + e)) // заглянуть в поток
                        .map(i -> 3 * i)
                        .collect(Collectors.toList())
        );

        // сортировка в обратном порядке
        System.out.println(
                strings.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList())
        );

        // flatMap
        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("one", "two", "three"),
                Arrays.asList("for"),
                Arrays.asList("five", "six")
        );

        System.out.println(
                listOfList.stream()
                        .flatMap(
                                list -> list.stream() // уплощение листов
                        )
                        .collect(Collectors.toList())
        );

        // терминальные операции
        // findFirst
        // Optional - класс который представляет собой либо
        // значение либо отсутствие значения
        System.out.println(
                strings.stream()
                        .filter(s -> s.contains("7")) // так как нет элементов с 7
                        .findFirst() // то вернется Optional.empty()
        );

        System.out.println(
                strings.stream()
                        .filter(s -> s.contains("7"))
                        .findFirst() // если элемента нет
                        .orElse("No such element") // альтернативное значение
        );

        // forEach
        strings.stream()
                .forEach(System.out::println);


        // List<String> strings = Arrays.asList("10", "20", "1", "10", "15", "50", "25");
        // anyMatch(Predicate<T>) - хотя бы один элемент удовлетворяет предикату
        System.out.println(
                strings.stream()
                        .anyMatch(s -> s.contains("5"))
        );

        // allMatch(Predicate<T>) - все элементы удовлетворяют
        System.out.println(
                strings.stream()
                        .allMatch(s -> s.contains("1"))
        );

        // noneMatch - никакой элемент не удовлетворяет предикату
        System.out.println(
                strings.stream().noneMatch("8"::contains)
        );

        // min / max
        System.out.println(
                strings.stream()
                        .max(Comparator.naturalOrder())
                        .get()
        );

        // reduce
        int[] digits = {2, 7, 3};

        System.out.println(
                Arrays.stream(digits).reduce(0, (i, j) -> i + j)
        );

        // напишите перемножение через reduce
        System.out.println(
                Arrays.stream(digits).reduce((i, j) -> i * j)
        );

        // List<String> strings = Arrays.asList("10", "20", "1", "10", "15", "50", "25");
        // преобразуйте в Integer и посчитайте сумму
        // используя reduce
        System.out.println(
                strings.stream()
                        .mapToInt(Integer::parseInt)
                        .reduce(0, Integer::sum)
        );

        // объедините в строку все элементы через reduce
        // "10, 20, 1, 10, 15, 50, 25"

        strings.stream()
                .reduce((s1, s2) -> s1 + ", " + s2)
                .ifPresent(System.out::println);

        // collect()
        // collect(toList()) - в список
        // collect(toCollection()) - в коллекцию
        // collect(toSet()) - в набор
        // collect(groupingBy()) - в map

        // List<String> strings = Arrays.asList("10", "20", "1", "10", "15", "50", "25");

        System.out.println(
                strings.stream()
                        .collect(
                                Collectors.groupingBy(
                                        s -> s.length()
                                )
                        )
        );

        // groupingBy
        // сгруппируйте значения по признаку делятся ли они на 5 без остатка
        // Map<Boolean, List<String>>
        System.out.println(
                strings.stream()
                        .collect(
                                Collectors.groupingBy(
                                        s -> Integer.parseInt(s) % 5 == 0
                                )
                        )
        );

        // toMap
        // List<String> strings = Arrays.asList("10", "20", "1", "10", "15", "50", "25");
        System.out.println(
                strings.stream()
                        .distinct()
                        .collect(
                                Collectors.toMap(
                                        Function.identity(), // отдает вход на выход
                                        // s -> s, // ключ
                                        s -> s.length() // значение
                                )
                        )
        );

    }
}
