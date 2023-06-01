package lesson17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson17 {
    public static void main(String[] args) {
        // Lambdas, Functional Interfaces, Method references.
        // SAM interface - Single abstract method -
        //     интерфейс с единственным абстрактным методом
        NoArgsReturnDouble returns10 = () -> 10;
        // реализация SAM-интерфейса может быть записано как лямбда-выражение
        NoArgsReturnDouble randomDouble = (/* параметры функции */) -> Math.random()*33;

        TwoIntsReturnsBoolean equalityCheck = new TwoIntsReturnsBoolean() {
            @Override
            public boolean function(int a, int b) {
                return a == b;
            }

            @Override
            public boolean remains(int a, int b) {
                return false;
            }
        };

        System.out.println(process(4,4, equalityCheck));
        System.out.println(process(5,7, equalityCheck));

        PredicateInt ifEven = i -> i % 2 == 0;
        List<Integer> ints = Arrays.asList(1,3,5,7,2,8);

        System.out.println(filter(ints, ifEven));

        List<String> names = Arrays.asList("Masha", "Sveta", "Max", "Alex", "Sam");

        StringConsumer printer = System.out::println;

        consume(names, printer);



    } // main

    public static void consume(List<String> stringList, StringConsumer consumer) {
        System.out.println(stringList);
    }

    public static List<String> mapper(List<String> strings, StringProcessor p) {
        List<String> result = new ArrayList<>();
        for (String s: strings) {
            result.add(p.function(s));
        }
        return result;
    }

    static boolean process (int i, int j, TwoIntsReturnsBoolean c) {
     return c.function(i, j);
    }

    public static List<Integer> filter (List<Integer> ints, PredicateInt p) {
        List<Integer> list = new ArrayList<>();
        for (int i: ints) {
            if (p.function(i))
                list.add(i);
        }
        return list;
    }
}
