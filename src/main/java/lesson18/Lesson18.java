package lesson18;

import java.util.Arrays;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lesson18 {
    public static void main(String[] args) {
        // Supplier
        // лямбда которая ничего не принимает, но что-то возвращает
        // применяется для отложенных вычислений

        Supplier<String> supplierString = new Supplier<String>() {
            @Override
            public String get() {
                return "123";
            }
        };
        System.out.println(
                supplierString.get()
        );

        Supplier<Double> doubleSupplier = () ->
                new Random().nextDouble();
        System.out.println(doubleSupplier.get());

        Predicate<String> longerThan5 = s -> s.length() > 5;
        Predicate<String> containsA = s -> s.toUpperCase().contains("A");

        Predicate<String> complexPredicate = longerThan5.or(containsA);
        System.out.println(
                Arrays.asList("Max", "Alexander", "XXX", "RRRRRRR")
                        .stream().filter(complexPredicate)
                        .collect(Collectors.toList())
        );

        Function<String, String> makeQuotedString = s -> "'" + s + "'";
        System.out.println(makeQuotedString.apply("max"));

        Function<Double, String> formatDouble = d -> "It's a double " + d;

        Function<Double, String> formatDoubleQuotes = formatDouble.andThen(makeQuotedString);
        System.out.println(
                formatDoubleQuotes.apply(4.998));

        System.out.println(
                makeQuotedString.compose(formatDouble).apply(5.69)
        );

        // identity отдает на выход свой вход
        Function<Long, Long> longIdentity = Function.identity();
        System.out.println(longIdentity.apply(3L));

        BiFunction<String, Double, Integer> formatter = (s, d) -> (s + " " + d).length();
        System.out.println(
                formatter.apply("prefix", 3.44));

        IntSupplier fib = new IntSupplier() {
            private int previous = 1;
            private int current = 2;
            @Override
            public int getAsInt() {
                int next = previous + current;
                previous = current;
                current = next;
                return previous;
            }
        };

        IntStream.generate(fib).limit(10).forEach(System.out::println);
    }
}
