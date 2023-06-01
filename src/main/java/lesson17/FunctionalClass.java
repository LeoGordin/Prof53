package lesson17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionalClass {
    // Consumer - "потребляет" экземпляр класса и ничего не возвращает
    public static void main(String[] args) {
        Consumer<Integer> display = System.out::println;
        display.accept(45);

        UnaryOperator<Integer> multiply = integer -> integer * 2;

        Consumer<List<Integer>> modifyList = list -> list.replaceAll(integer -> 2*integer);


        List<Integer> list = new  ArrayList<Integer>(Arrays.asList(1, 2, 4, 8));
        modifyList.accept(list);
        System.out.println(list);





        Consumer<List<Integer>> displayList = list1 -> list.forEach(System.out::println);
        displayList.accept(list);

        //Predicate - тестирует элемент и выдает boolean
        // IntPredicate, DoublePredicate, LongPredicate
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
        // BiPredicate - принимает на вход 2 элемента

        list.stream().filter(i -> i > 10).forEach(System.out::println);

        // Function<T,R> принимает на вход элемент одного типа, обрабаывает и
        // возвращает элемент другого типа
        // напишите реализацию Function которая возвращает
        // длину строки
        Function<String, Integer> stringLength = string -> string.length();

        System.out.println(stringLength.apply("test"));

        // Supplier - поставщик
        // ничего не принимает на вход и возвращает элемент определенного типа
        // Supplier<Double> randomDouble = () -> Math.random();
        // IntSupplier, DoubleSupplier, LongSupplier
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html
        Supplier<Double> randomDouble = Math::random;

        System.out.println(randomDouble.get());

        List<String> capitals = new ArrayList<>(Arrays.asList(
                "Canberra", "Buenos-Aires", "London", "Warsaw"
        ));

        capitals.stream().filter(s -> s.contains("a")).forEach(System.out::println);

        capitals.stream().map(s -> s.toLowerCase()).filter(s -> s.contains("a")).forEach(System.out::println);

        List<Integer> digits = new ArrayList<>(Arrays.asList(1, 2, 5, 10, 15, 24, 3));

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
