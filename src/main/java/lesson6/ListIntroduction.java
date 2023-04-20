package lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIntroduction {
    public static void main(String[] args) {
        //Array
        //List - список элементов определенного типа - может динамически меняться в размерах
        //Set - набор неповторяющихся элементов определенного типа
        //Map - пара из ключа и значения заданных типов
        // ... - другие контейнеры

        List<String> countries = new ArrayList<>();

        countries.add("France");
        countries.add("Germany");
        countries.add("Denmark");

        System.out.println(countries);
        countries.add(0, "Poland");
        System.out.println(countries);
        System.out.println(countries.size());
        System.out.println(countries.get(3)); // изменение по индексу
        countries.set(0, "Norway"); // изменение по значению
        System.out.println(countries);

        countries.remove(0); //удаление по индексу
        countries.remove("France"); // удаление по значению
        System.out.println(countries);
        System.out.println(
                countries.contains("France") // есть ли элемент в списке
        );
        System.out.println(
                countries.indexOf("Denmark") // позиция элемента в списке
        );

        countries.add("Chad");
        countries.add("Zulu");
        countries.add("Canada");

        printStringsGreaterThan4(countries);

        // countries.stream().filter(s -> s.length() > 5).forEach(System.out::println);

        List<String> names = Arrays.asList("Max", "Amalia", "Dina", "Sergey");
        System.out.println(names);
//        names.add("Sam");
//
        List<String> capitals = new ArrayList<>(
                Arrays.asList("Warsaw", "Vilnius", "Riga", "Berlin")
        );
        capitals.add("Prague");

        System.out.println(capitals);

        countries.addAll(capitals);
        System.out.println(countries);

        System.out.println(
                compare(
                        Arrays.asList("Dima", "Max", "Sveta"),
                        Arrays.asList("Dima", "Anna", "Alina")
                )
        );

        // в коллекциях могут быть только объекты ссылочных типов
        // List<int> b; !!!
        List<Integer> ints = new ArrayList<>();


    }

    public static void printStringsGreaterThan4 (List<String> a)
    {
//        for (int i = 0; i < a.size(); i++)
//        {
//            if (a.get(i).length() > 5)
//            {
//                System.out.println(a.get(i));
//            }
//        }

        for (String s : a) {
            if (s.length() > 5) {
                System.out.println(s);
            }
        }
    }

    public static List<Boolean> compare(List<String> a, List<String> b) {

        List<Boolean> c = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
//            if (a.get(i).equals(b.get(i)))
//                c.add(true);
//            else
//                c.add(false);
//            }

            c.add(
                    a.get(i).equals(b.get(i))
            );
        }

        return c;
    }

}
