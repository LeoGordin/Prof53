package lesson15;

import java.util.*;

public class Lesson15 {
    public static void main(String[] args) {
        // порядок обхода не гарантируется
        // элементы будут возвращаться в удобном для HashMap порядке
        Map<String, String> capitals = new HashMap<>();
        capitals.put("Hungary", "Budapest");
        capitals.put("Poland", "Warsaw");
        capitals.put("Estonia", "Tallinn");
        capitals.put("Moldova", "Kishinau");
        capitals.put("Austria", "Vienna");
        System.out.println(capitals.size()); // сколько элементов
        System.out.println(capitals.get("Poland")); // Warsaw - получение значения по ключу
        System.out.println(capitals.get("France")); // null так как нет
        // отображения с таким ключом
        System.out.println(capitals.containsKey("Hungary")); // true
        System.out.println(capitals.containsValue("London")); // false

        for (String key : capitals.keySet()) {
            // напишите код который распечатает отображения
            // только для стран содержащих букву "o"
            if (key.contains("o"))
                System.out.println("Country: " + key + " capital: " + capitals.get(key));
        }

        for (String value : capitals.values()) {
            System.out.println("Capital: " + value);
        }

        // Entry это пара из ключа и значения
        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            System.out.println("Entry key: " + entry.getKey() + " value: " + entry.getValue());
        }

        capitals.remove("France"); // удаление отображения по ключу

        // поиск дубликатов
        // поиск уникальных значений
        // работа с дубликатами и уникальными значениями

        List<Integer> numbers = Arrays.asList(1, 2, 1, 4, 4, 5, 4, 7, 1);
        countNumbers(numbers);


        Map<String, String> aero = new HashMap<>();
        aero.put("Berlin", "London");
        aero.put("Tokyo", "Seoul");
        aero.put("Mumbai", "Berlin");
        aero.put("Seoul", "Mumbai");

        findTicket("Tokyo", "London", aero);

        List<String> words = Arrays.asList("hello", "hi", "nice", "hell");

        // {
        //  "h" -> {"hello", "hi", "hell"},
        //  "n" -> {"nice"}
        //  }
        System.out.println(
                findWords(words)
        );


    } // окончание main

    // вернуть map где ключом будет первая буква слова
    // а значением набор всех слов где она является первой буквой
    public static Map<String, Set<String>> findWords(List<String> words) {
        Map<String, Set<String>> result = new HashMap<>();
        for (String w : words) {
            String key = w.substring(0, 1);
            Set<String> value = result.get(key);
            if (value == null) {
                value = new HashSet<>();
            }
            value.add(w);
            result.put(key, value);
        }
        return result;
    }

    // перерыв до 20:41



    // напишите функцию, которая подбирает человеку сложный билет
    public static void findTicket(String first, String last, Map<String, String> db) {
        String current = first; // текущий аэропорт
        String next = ""; // следующий
        while (current != null && !current.equals(last)) {
            next = db.get(current);
            System.out.println(current + "->" + next);
            current = next;
        }
    }


    // напишите функцию которая распечататет сколько раз каждое число
    // присутсвует в списке
    public static void countNumbers(List<Integer> ints) {
        // TreeMap хранит все свои пары по возрастанию ключа
        Map<Integer, Integer> counter = new TreeMap<>();
        for (int i : ints) {
            // ключ i уже есть в counter
            if (counter.containsKey(i)) {
                // получить из counter значение
                int value = counter.get(i);
                // увеличить значение на 1
                value++;
                // сохранить пару i->value в counter
                counter.put(i, value);
            } else {
                // ключ i в counter отсутствует
                // сохраним в counter пару i->1
                counter.put(i, 1);
            }
        }
        for (int i : counter.keySet()) {
            System.out.println("number: " + i + " count: " + counter.get(i));
        }
    }

}
