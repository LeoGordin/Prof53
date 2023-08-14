package lesson17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson17 {
    public static void main(String[] args) {
        // Lambdas, Functional Interfaces, Method references.
        // SAM interface - Single abstract method -
        //     интерфейс с единственным абстрактным методом



        // Создайте экземпляр интерфейса NoArgsReturnDouble который бы возвращал 10
        NoArgsReturnDouble returns10 = new NoArgsReturnDouble() {
            @Override
            public double function() {
                return 10;
            }
        } ;

        // реализация SAM-интерфейса может быть записано как лямбда-выражение
        NoArgsReturnDouble randomDouble = (/* параметры */) -> Math.random()*33;

        // напишите интерфейс в пакете lesson17
        // TwoIntsReturnsBoolean c function принимающей два int и возвращающей boolean

        // напишите в виде лямбды реализацию TwoIntsReturnsBoolean которая проверяет
        // аргументы на равенство
        TwoIntsReturnsBoolean equalityCheck = (i, j) -> i == j;
        System.out.println("равны ли 10 и 12 " + equalityCheck.function(10, 12));
        System.out.println("равны ли 3 и 3 " + equalityCheck.function(3, 3));

        System.out.println("равны ли 5 и 7 " + process(5,7, equalityCheck));

        // до 19:38

//        TwoIntsReturnsBoolean dividedBy = new TwoIntsReturnsBoolean() {
//            @Override
//            public boolean function(int i, int j) {
//                return i % j == 0;
//            }
//        };

        TwoIntsReturnsBoolean dividedBy = (i, j) -> i % j == 0;

        System.out.println("делится ли 33 на 11 без остатка " +
                process(
                        33,
                        11,
                        (k,l) -> k % l == 0
                )
        );

        // напишите SAM интерфейс PredicateInt который принимает на вход целое
        // и возвращает boolean

        List<Integer> ints = Arrays.asList(1,3,5,7,2,8);
        // создайте предикат который проверит числа на четность
        // отфильтруйте список чисел с помощью этого предиката и
        // распечатайте результат
        System.out.println(
                filter(
                        ints,
                        (i) -> i % 2 == 0
                )
        );

        // напишите интерфейс StringProcessor который принимает на вход строку и
        // возвращает строку

        List<String> names = Arrays.asList("Masha", "Sveta", "Max", "Alex", "Sam");
        // напишите преобразование этого списка к верхнему регистру
        // через mapper
        System.out.println(
                mapper(
                        names,
                        String::toUpperCase
                )
        );

        // StringProcessor toUpper = (s) -> s.toUpperCase();
        StringProcessor toUpper = String::toUpperCase;

        // напишите интерфейс StringConsumer который получает String
        // и ничего не возвращает

//        StringConsumer printer = new StringConsumer() {
//            @Override
//            public void function(String s) {
//                System.out.println(s);
//            }
//        };

//        StringConsumer printer = s -> System.out.println(s);

        StringConsumer printer = System.out::println; // ссылка на статический метод

        // consume(names, printer);
        consume(names, System.out::println);

    } // main


    public static void consume(List<String> strings, StringConsumer c)
    {
        // напишите StringConsumer который распечатывает строку
        // и вызовите его для всех строк в списке
        for(String s : strings)
            c.function(s);
    }

    public static List<String> mapper(List<String> strings, StringProcessor p)
    {
        // нужно возвращать список строк после применения к каждой из них
        // StringProcessor-а
        List<String> result = new ArrayList<>();
        for (String s: strings)
            result.add(p.function(s));
        return result;
    }

    // напишите функцию которая принимает на вход List<Integer> и
    // возвращает список только тех целых для которых PredicateInt возвратит true
    public static List<Integer> filter(List<Integer> ints, PredicateInt p)
    {
        List<Integer> result = new ArrayList<>();
        for(int i : ints)
            if(p.function(i))
                result.add(i);
        return result;
    }


    // напишите функцию static boolean process(int i, int j, TwoIntsReturnsBoolean c)
    // которая возвращает результат выполнения TwoIntsReturnsBoolean с целыми аргументами
    static boolean process(int i, int j, TwoIntsReturnsBoolean c) {
        return c.function(i, j);
    }



}
