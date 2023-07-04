package lesson28;

import lesson13.Player;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenericTest {
    public static <E, T> void main(String[] args) {
        List<java.io.Serializable> list = new ArrayList<>();
        list.add("Java is");
        String text = list.get(0) + " programming language";
        // String text = list.get(0); // не компилируется так как нельзя приравнять объект и строку
        System.out.println(text);
        list.add(3);

        List<String> words = new ArrayList<>();
        words.add("Hello ");
        // words.add(3); // не компилируется так как список именно строк

        debug(123);

        debug("String");

        log(123);
        log("123");
        log(12.23);

        System.out.println(firstElement(words));

        System.out.println(firstAndLast(words));

        Pair<String, Integer> p1 = new PairImpl<>("1", 2);
        Pair<String, Integer> p2 = new PairImpl<>("1", 2);
        Pair<String, Integer> p3 = new PairImpl<>("3", 5);

        System.out.println(equals(p1, p2));
        System.out.println(equals(p1, p3));

    }

    // напишите функцию maxOfList
    public static <T> Optional<T> maxOfArray(T [] array, Comparator<T> comparator)
    {
        if (array.length <=0) throw new RuntimeException();
        return Arrays.stream(array).max(comparator);
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
    public static <T extends Number> List<T> fromNumberToList(T [] array)    {
        return Arrays.stream(array)
                // peek - позволяет выполнить действия с элементом не меняя его
                .peek(n -> System.out.println("number: " + n.doubleValue()))
                .collect(Collectors.toList());
    }

    public static <T,R> List fromArrayToList (T [] array,
                                                   Predicate<T> predicate,
                                                   Function<T,R> mapper) {
        return Arrays.stream(array)
                .filter(predicate)
                .map(mapper)
                .collect(Collectors.toList());
    }

    // напишите шаблонную функцию, которая сделает из массива список
    public static <T> List<T> fromArrayToList(T [] array)
    {
        return new ArrayList<>(Arrays.asList(array));
    }

    // напишите функцию которая сравнит две пары
    // пары равны если равны и ключи и значения
    // до 20:15
    public static <K,V> boolean equals(Pair<K,V> p1, Pair<K,V> p2)
    {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    public static <T> Pair<T,T> firstAndLast (List<T> tList) {
        return new PairImpl<>(
                tList.get(0),
                tList.get(tList.size() - 1)
        );
    }

    public static void debug(int i) {
        System.out.println("It's an int, value is: " + i);
    }

    public static void debug(String s) {
        System.out.println("It's a String, value is: " + s);
    }

    public static <T> void log(T t) {
        System.out.println("It's a " + t.getClass().getSimpleName() + ", value is: " + t);
    }

    public static <T> T firstElement (List<T> list) {
            return list.get(0);
    }
}
