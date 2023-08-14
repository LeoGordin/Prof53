package lesson17;

import lesson3.pizza.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionalTest {
    public static void main(String[] args) {
        // Consumer - "потребляет" экземпляр класса и ничего не возвращает
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html
        Consumer<Integer> display = System.out::println;
        display.accept(45);

        // Operator это Function у которой входной и выходной тип совпадают
        UnaryOperator<Integer> multiply = integer -> integer * 2;

        Consumer<List<Integer>> modifyList = list -> list.replaceAll(integer -> 2*integer);

        List<Integer> ints = new ArrayList<Integer>(Arrays.asList(1,2,4,8)) ;
        modifyList.accept(ints);
        System.out.println(ints);

        // Consumer<List<Integer>> displayList = list -> list.forEach(i -> System.out.println(i));
        Consumer<List<Integer>> displayList = list -> list.forEach(System.out::println);
        displayList.accept(ints);

        // Predicate - тестирует элемент и выдает true/false
        // IntPredicate, DoublePredicate, LongPredicate
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
        // BiPredicate - принимает на вход 2 элемента
        ints.stream().filter(i -> i > 10).forEach(System.out::println);

        // Function<T,R> принимает на вход элемент одного типа, обрабаывает и
        // возвращает элемент другого типа
        // напишите реализацию Function которая возвращает
        // длину строки
        // Function<String, Integer> stringLength = string -> string.length();
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
        Function<String, Integer> stringLength = String::length;
        System.out.println(stringLength.apply("test")); // 4

        // Supplier - поставщик
        // ничего не принимает на вход и возвращает элемент определенного типа
        // Supplier<Double> randomDouble = () -> Math.random();
        // IntSupplier, DoubleSupplier, LongSupplier
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html
        Supplier<Double> randomDouble = Math::random;
        System.out.println(randomDouble.get());




        List<String> capitals = Arrays.asList("Canberra", "Buenos-Aires", "London", "Warsaw");

        // отфильтруйте только те что содержат букву "a"
        capitals.stream().filter(s -> s.contains("a")).forEach(System.out::println);

        // map(Function<T,R>)
        // добавьте конвертацию в нижний регистр перед фильтрацией
        // capitals.stream().map(s -> s.toLowerCase()).filter(s -> s.contains("a")).forEach(System.out::println);
        capitals.stream().map(String::toLowerCase).filter(s -> s.contains("a")).forEach(System.out::println);


        List<Integer> digits = Arrays.asList(1,2,5,10,15, 24, 3);
        digits.stream().filter(i -> i > 10).filter(i -> i < 20).forEach(System.out::println);

        Function<String, String> toLower = String::toLowerCase;
        Function<String, Integer> length = String::length;

        Function<String, Integer> combine = toLower.andThen(length);

        List<String> result = capitals.stream()
                .map(String::toLowerCase)
                .filter(s -> s.contains("a"))
                .collect(Collectors.toList());

        System.out.println(result);


    }

}
