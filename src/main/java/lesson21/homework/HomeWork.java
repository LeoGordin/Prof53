package lesson21.homework;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HomeWork {
    public static void main(String[] args) {
        String[] lines = {
                "one two three four we need this", // 0
                "can one be happy", // 1
                "three of us make one need", // 2
                "this will be four"}; // 3

        // Создать map из слова и списка из номеров строк, к которых эти
        // слова присутствуют, например, для слова "one" пара в map должна быть
        // "one" -> [0, 1, 2]

        System.out.println(
                IntStream.range(0, lines.length) // int
                        .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, lines[i]))
                        .flatMap(
                                p -> Arrays.stream(p.getValue().split(" "))
                                        .map(w -> new AbstractMap.SimpleEntry(w, p.getKey()))
                        )
                        .collect(
                                Collectors.groupingBy(p -> p.getKey())
                        )
                        .entrySet().stream()
                        .collect(
                                Collectors.toMap(
                                        p -> p.getKey(),
                                        p -> p.getValue().stream()
                                                .map(
                                                        pair -> pair.getValue()
                                                )
                                                .collect(Collectors.toList())
                                )
                        )
        );


        // Создать map из строки в ее длину
        Map<String, Integer> stringToLength =
                Arrays.stream(lines)
                        .collect(
                                Collectors.toMap(
                                        Function.identity(),
                                        String::length
                                )
                        );
        System.out.println(stringToLength);



    }
}
