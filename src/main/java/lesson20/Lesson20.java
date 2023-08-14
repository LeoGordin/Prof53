package lesson20;

import lesson2.crossword.B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lesson20 {
    // filter n -> 0 .. n
    // map n -> n
    // flatMap 1 -> n

    public static void main(String[] args) {
        Integer[][] twoDimensionalArray = {
                {1, 2, 3, -5},
                {5, 6, 7, 10},
                {11},
                {14, 22}
        };


        System.out.println(
                Arrays.stream(twoDimensionalArray)
                        .flatMap(array -> Arrays.stream(array))
                        .collect(Collectors.toList())
        );

        List<List<String>> names = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList("Misha", "Alex"),
                        Arrays.asList("Tim", "Kris", "Tom"),
                        Arrays.asList("Magda", "Tom", "Tim")
                )
        );

        // соберите в контейнер
        // не повторяющиеся имена
        // не содержащие буквы 'a' в любом регистре
        System.out.println(
                names.stream() // List<String>
                        .flatMap(list -> list.stream()) // String
                        .filter(string -> !string.toLowerCase().contains("a"))
                        .collect(Collectors.toSet())
        );

        // Kris Tom Tom Tim Tim
        List<String> nonUniqueNames = Arrays.asList("Kris", "Tom", "Tom", "Tim", "Tim");
        // выведите только имена присутствующие один раз

        System.out.println(
                nonUniqueNames.stream()
                        .collect(
                                Collectors.groupingBy(
                                        word -> word
                                )
                        )
                        .entrySet().stream()
                        .filter(pair -> pair.getValue().size() == 1)
                        .map(pair -> pair.getKey())
                        .collect(Collectors.toList())
        );

        List<String> countries = Arrays.asList(
                "Tchad", "Sweden", "Finland", "Germany", "Poland", "France",
                "Norway", "Belgium", "Holland"
        );

        // сгруппируйте по длине
        System.out.println(
                countries.stream()
                        .collect(
                                Collectors.groupingBy(country -> country.length())
                        )
                        // соберите в List длины стран - первые элементы пар (ключи)
                        .entrySet().stream()
                        .map(pair -> pair.getKey())
                        .collect(Collectors.toList())
        );

        Order grocery = new Order(
                new OrderItem("mango", 5, 1.45),
                new OrderItem("potato", 3, 0.79),
                new OrderItem("coca-cola", 8, 0.91)
        );

        Order utility = new Order(
                new OrderItem("water", 60, 4.3),
                new OrderItem("electricity", 5, 6.91)
        );

        List<Order> orders = Arrays.asList(grocery, utility);
        // подсчитайте затраты из двух счетов
        // 5*1.45+3*0.79 ...

        System.out.println(
                orders.stream() // Order
                        .flatMap(order -> order.getItems().stream()) // OrderItem
                        .mapToDouble(item -> item.getQuantity() * item.getUnitPrice()) // double
                        .sum()
        );

        String[][] words = {
                {"Hello", "world"},
                {"Hello", "java", "doc"},
                {"Hello", "student"},
                {"Welcome", "to", "university"}
        };

        // посчитайте количество слов (10)
        System.out.println(
                Arrays.stream(words)
                        .flatMap(Arrays::stream)
                        .count()
        );

        // посчитайте количество уникальных слов (8)
        System.out.println(
                Arrays.stream(words)
                        .flatMap(Arrays::stream)
                        .distinct() // только уникальные
                        .count()
        );

        List<Book> books = Arrays.asList(
                new Book("Kingdom of Heaven", "Alex", "Max", "Sam"),
                new Book("War and Peace", "Alexey", "Sveta", "Max"),
                new Book("Movable feast", "Ernest", "Max", "Sam"),
                new Book("The catcher in the ray", "Jerome", "Ernest")
        );


        // посчитайте уникальных авторов (7)
        System.out.println(
                books.stream() // Book
                        .flatMap(book -> book.getAuthors().stream()) // String
                        .distinct()
                        .count()
        );

        // для книг в названии которых больше 2 слов
        // распечатайте уникальных авторов в имени которых есть буква 'e'
        System.out.println(
                books.stream() // Book
                        .filter(book -> book.getTitle().split(" ").length > 2)
                        .flatMap(book -> book.getAuthors().stream()) // String
                        .filter(author -> author.toLowerCase().contains("e"))
                        .collect(Collectors.toSet())
        );

        System.out.println(
                Arrays.toString(
                        IntStream.rangeClosed(1, 5)
                                .toArray()
                )
        );

//        System.out.println(
//                Stream.iterate(200, i -> i + 5)
//                        .takeWhile(i -> i < 230)  // берет элементы из потока пока выполняется предикат
//                        // после этого поток закрывается
//                        .collect(Collectors.toList())
//        );
    }
}
