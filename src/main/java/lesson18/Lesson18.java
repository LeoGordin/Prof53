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

//        Supplier<String> supplierString = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "123";
//            }
//        };

        Supplier<String> supplierString = () -> "123";
        System.out.println(
                supplierString.get()
        );

        Supplier<Double> doubleSupplier = () -> new Random().nextDouble();
        System.out.println(
                doubleSupplier.get()
        );


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



        // Predicate
        // это функция которая тестирует элемент
        // возвращает boolean
        // and() or() negate()
        // Predicate.not()
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
        // напишите предикат для строк который возвращает true только для
        // строк длинее 5 символов

//        Predicate<String> longerThan5 = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.length() > 5;
//            }
//        };
        Predicate<String> longerThan5 = s -> s.length() > 5;
        Predicate<String> containsA = s -> s.toUpperCase().contains("A");

        Predicate<String> complexPredicate = longerThan5.or(containsA);
        System.out.println(
                Arrays.asList("Max", "Alexander", "XXX", "RRRRRRR")
                        .stream().filter(complexPredicate)
                        .collect(Collectors.toList())
        );

        // Function<T,R>
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
        // функция которая принимает на вход экземпляр какого-то класса
        // и возвращает экземпяр другого
        // andThen() compose()
        // напишите Function которая закавычивает строки
        // max -> 'max'
        Function<String, String> quote = string -> "'" + string + "'";
        System.out.println(quote.apply("max"));

        // 4.33 -> "It's a double 4.33"
        Function<Double, String> formatDouble = d -> "It's a double " + d;

        // напишите функцию из formatDouble+quote
        Function<Double, String> complexFunction = formatDouble.andThen(quote);
        System.out.println(
                complexFunction.apply(3.333)
        );
        System.out.println(
                quote.compose(formatDouble).apply(3.44444)
        );

        // identity отдает на выход свой вход
        Function<Long, Long> longIdentity = Function.identity();
        System.out.println(longIdentity.apply(3L));

        // BiFunction<T,U,R>
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html
        BiFunction<String, Double, Integer> formatter = (s, d) -> (s + " " + d).length();
        System.out.println(
                formatter.apply("prefix", 3.44) // 11
        );


    }
}
