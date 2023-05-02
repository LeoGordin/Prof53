package lesson9;

import java.util.*;

public class SetTester {
    public static void main(String[] args) {
        // Set - коллекция для хранения неповторяющихся элементов
        // HashSet - основан на хэш-коде - операции доступа 0(1)
        // LinkedHashSet - хранит элементы в порядке вставки
        // TreeSet - хранит элементы в определенном порядке сортировки

        //применение:
        // 1) Удаление дубликатов
        // 2) Поиск дубликатов


        Set<String> groups = new HashSet<>();
        groups.add("ABBA");
        groups.add("Guns'n'Roses");
        groups.add("Pearl Jam");
        // groups.add("ABBA"); // Элемент повторяется, поэтому автоматически удаляется
        groups.add("Beatles");
        System.out.println(groups);

        for (String g : groups) {
            System.out.println("group: " + g);
        }

        TreeSet<String> groupsTree = new TreeSet<>(groups);
        System.out.println(groupsTree);

        // groups.contains("ABBA");

        Set<String> slice = groupsTree.subSet("C", "R");
        System.out.println(slice);

        // groupsTree.floor("C") все что меньше
        // groupsTree.ceiling("G") все что больше

        Set<String> names = new HashSet<>();
        names.add("Alex");
        names.add("Abba");
        names.add("Kristina");

        groups.addAll(names);
        System.out.println(groups);

        System.out.println(groups.containsAll(names)); //находятся ли все элементы сета в другом

        groups.removeAll(names);
        System.out.println(groups);

        // groups.retainAll(names) // общие элементы сетов

        String [] gr = new String[groups.size()];
        groups.toArray(gr);

        System.out.println(letters("Java java go go"));

        System.out.println(
                getDoubles("dima max sveta max lena gena lena sveta max")
        );

    }

    public static Set<String> letters (String s) {

        String [] letters = s.split("");
        return new LinkedHashSet<>(Arrays.asList(letters));
    }

    public static Set<String> getDoubles(String s)
    {

        Set<String> doubles = new HashSet<>(); // дубликаты
        Set<String> words = new HashSet<>(); // слова
        for(String w : s.split(" ")) {
            if(words.contains(w))
                doubles.add(w);
            words.add(w);
        }
        return doubles;
    }
}
