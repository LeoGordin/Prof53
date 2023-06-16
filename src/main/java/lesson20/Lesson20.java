package lesson20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lesson20 {
    // filter n -> 0 .. n
    // map n -> n
    // flatMap 1 -> n

    public static void main(String[] args) {
        Integer [][] twoDimensionalArray = {
                {1,2,3},
                {5,6,7, 10},
                {11},
                {14, 22}
        };

        System.out.println(
                Arrays.stream(twoDimensionalArray)
                        .flatMap(Arrays::stream)
                        .collect(Collectors.toList())
        );

        List<List<String>> names = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList("Misha", "Alex"),
                        Arrays.asList("Tim", "Kris", "Tom"),
                        Arrays.asList("Magda", "Tom", "Tim")
                )
        );

        System.out.println(
                Stream.of(names)
                        .flatMap(List::stream)
                        .filter(strings -> strings.stream().noneMatch(s -> s.contains("a")))
                        .collect(Collectors.toSet())
        );

        List<String> nonUniqueNames = Arrays.asList("Kris", "Tom","Tom","Tim","Tim");

        System.out.println(
                nonUniqueNames.stream()
                        .collect(Collectors.groupingBy(
                                word -> word
                        )).entrySet().stream()
                        .filter(pair -> pair.getValue().size() == 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList())

        );

        List<String> countries = new ArrayList<>(Arrays.asList(
                "Chad", "Sweden", "Finland", "Germany", "Poland", "France",
                "Norway", "Belgium", "Netherlands"
        ));

        System.out.println(
                new ArrayList<>(countries.stream()
                        .collect(Collectors.groupingBy(
                                String::length
                        )).keySet())
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

        System.out.println(
                orders.stream()
                        .flatMap(order -> order.getItems().stream())
                        .mapToDouble(item -> item.getQuantity() * item.getUnitPrice())
                        .sum()
        );

        String [][] words = {
                {"Hello", "world"},
                {"Hello", "java", "doc"},
                {"Hello", "student"},
                {"Welcome", "to", "university"}
        };

        System.out.println(
                Arrays.stream(words)
                        .flatMap(Arrays::stream)
                        .count()
        );

        System.out.println(
                Arrays.stream(words)
                        .flatMap(Arrays::stream)
                        .distinct()
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

        System.out.println(
                books.stream()
                        .filter(book -> book.getTitle().split(" ").length > 2)
                        .flatMap(book -> book.getAuthors().stream())
                        .filter(author -> author.toLowerCase().contains("e"))
                        .collect(Collectors.toSet())
        );

        System.out.println(
                Arrays.toString(
                        IntStream.rangeClosed(1, 5)
                                .toArray()
                )
        );

        System.out.println(
                Stream.iterate(200, i -> i + 5)
                        .takeWhile(i -> i < 230)  // берет элементы из потока пока выполняется предикат
                        // после этого поток закрывается
                        .collect(Collectors.toList())
        );


    }
}
