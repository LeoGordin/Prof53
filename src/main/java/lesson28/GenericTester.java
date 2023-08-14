package lesson28;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenericTester {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Java is");
        String text = list.get(0) + " programming language";
        // String text = list.get(0); // не компилируется так как нельзя приравнять объект и строку
        System.out.println(text);
        list.add(3);

        List<String> words = new ArrayList<>();
        words.add("Hello ");
        // words.add(3); // не компилируется так как список именно строк

        debug(123);
        debug("Hello");

        log("Hello world");
        log(34.55);

        System.out.println(firstElement(Arrays.asList("Hello", "World")));
        System.out.println(firstAndLast(Arrays.asList("Hello", "World")));


        Pair<String, Integer> p1 = new PairImpl<>("Hello", 4);
        Pair<String, Integer> p2 = new PairImpl<>("Hello", 4);
        Pair<String, Integer> p3 = new PairImpl<>("World", 5);

        System.out.println( // true
                equals(p1, p2)
        );

        System.out.println( // false
                equals(p2, p3)
        );

        String[] names = {"Max", "Elena", "Xenia", "Alexander", "Sveta"};
        System.out.println(fromArrayToList(names));

        System.out.println(
                fromArrayToList(
                        names,
                        (String r) -> r.length() > 3, // predicate
                        String::length // mapper
                        )
        );

        Double [] numbers = {1.0, 4.33, -12.3, 34.0};
        System.out.println(
                fromNumberToList(numbers, 3.3)
        );

    } // окончание main

    public static <T> Optional<T> maxOfArray(T [] array, Comparator<T> comparator)
    {
        return Arrays.stream(array)
                .max(comparator);
    }

    public static <T extends Number & Comparable<T>> List<T> fromNumberToList(T [] array, T bound)
    {
        return Arrays.stream(array)
                .peek(n -> System.out.println("number: " + n.doubleValue()))
                .filter(n -> n.compareTo(bound) > 0)
                .collect(Collectors.toList());
    }

    // extends Number означает, что в эту функцию можно педелать только
    // массив классов, являющихся потомками Number
    public static <T extends Number> List<T> fromNumberToList(T [] array)
    {
        return Arrays.stream(array)
                // peek - позволяет выполнить действия с элементом не меняя его
                .peek(n -> System.out.println("number: " + n.doubleValue()))
                .collect(Collectors.toList());
    }


    public static <T, R> List<R> fromArrayToList(
            T[] array,
            Predicate<T> predicate,
            Function<T, R> mapper
    ) {
        return Arrays.stream(array)
                .filter(predicate)
                .map(mapper)
                .collect(Collectors.toList());
    }


    // напишите шаблонную функцию, которая сделает из массива список
    public static <T> List<T> fromArrayToList(T[] array) {
        return Arrays.stream(array)
                .collect(Collectors.toList());
    }

    // напишите функцию которая сравнит две пары
    // пары равны если равны и ключи и значения
    public static <K, V> boolean equals(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue())
                ;
    }

    // напишите функцию firstAndLast которая принимает на вход список любого типа
    // и возвращает в виде пары первый и последний элемент
    public static <T> Pair<T, T> firstAndLast(List<T> list) {
        return new PairImpl<>(
                list.get(0),
                list.get(list.size() - 1)
        );
    }


    // напишите функцию firstElement которая принимает на вход список какого угодно типа
    // и возвращает первый элемент этого списка
    public static <T> T firstElement(List<T> list) {
        return list.get(0);
    }


    public static <T> void log(T t) // Т - просто какой-то тип, не важно какой
    {
        System.out.println(
                "It's a " + t.getClass().getSimpleName() + " value is: " + t
        );
    }

    public static void debug(String s) {
        System.out.println("It's an String, value is: " + s);
    }

    public static void debug(int i) {
        System.out.println("It's an int, value is: " + i);
    }
}
