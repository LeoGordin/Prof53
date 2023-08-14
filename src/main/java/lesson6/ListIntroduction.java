package lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIntroduction {
    public static void main(String[] args) {
        // Array
        // List - список элементов определенного типа - может динамически менятся в размерах
        // Set - набор неповторяюшихся элементов определенного типа
        // Map - пара из ключа и значения заданных типов
        // ... - другие контейнеры

        List<String> countries = new ArrayList<>();
        countries.add("France"); // добавлние
        countries.add("Germany");
        countries.add("Denmark");
        System.out.println(countries);
        countries.add(1, "Poland"); // добавление по индексу
        System.out.println(countries);
        System.out.println(countries.size());
        System.out.println(countries.get(3));
        countries.set(0, "Norway");  // изменение по индексу
        System.out.println(countries);
        //countries.add(8, "Andorra");
        //System.out.println(countries);
        countries.remove(0);  // удаление по индексу
        countries.remove("Poland"); // удаление по значению
        System.out.println(countries);
        System.out.println(
                countries.contains("Denmark") // есть ли элемент в списке
        );
        System.out.println(
                countries.indexOf("Denmark") // позиция элемента в списке
        );

        countries.add("Chad");
        System.out.println(countries);
        printStringsGreaterThan4(countries);

        // countries.stream().filter(s -> s.length() > 5).forEach(System.out::println);

        // константного размера - нельзя добавлять и удалять элементы
        List<String> names = Arrays.asList("Max", "Amalia", "Dina", "Sergey");
        System.out.println(names);
        // names.add("Sam"); // не будет работать

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

    // напишите функцию которая принимает на вход два списка строк одинаковой длины
    // и возвращает список Boolean - true если элементы с одним и тем-же индексом
    // попарно одинаковы и false наоборот
    // [Dima, Max, Sveta], [Dima, Anna, Alina] -> [true, false, false]
    public static List<Boolean> compare(List<String> a, List<String> b)
    {
        List<Boolean> r = new ArrayList<>();
        for(int i = 0; i < a.size(); i++)
        {
//            if(a.get(i).equals(b.get(i)))
//                r.add(true);
//            else
//                r.add(false);
            r.add(
                    a.get(i).equals(b.get(i))
            );
        }
        return r;
    }



    // Напишите функцию котороая принимает List<String> и распечатывает только
    // элементы длины больше 5
    public static void printStringsGreaterThan4(List<String> a)
    {
//        for(int i = 0; i < a.size(); i++)
//        {
//            if(a.get(i).length() > 5)
//                System.out.println(a.get(i));
//        }
        for (String s : a) {
            if (s.length() > 5)
                System.out.println(s);
        }
    }


}
