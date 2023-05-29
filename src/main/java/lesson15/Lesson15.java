package lesson15;

import java.util.*;

public class Lesson15 {
    public static void main(String[] args) {
        Map<String, String> capitals = new HashMap<>();
        capitals.put("Hungary", "Budapest");
        capitals.put("Poland", "Warsaw");
        capitals.put("Estonia", "Tallinn");
        capitals.put("Moldova", "Kishinau");
        capitals.put("Austria", "Vienna");

        System.out.println(capitals.size()); // сколько элементов

        System.out.println(capitals.get("Poland"));
        System.out.println(capitals.get("France"));

        System.out.println(capitals.containsKey("Hungary"));
        System.out.println(capitals.containsValue("London"));

//        for (String key : capitals.keySet()) {
//            System.out.println("Country: " + key + ", capital: " + capitals.get(key));
//        }

//        for (String key : capitals.keySet()) {
//            if(key.contains("o"))
//                System.out.println("Country: " + key + ", capital: " + capitals.get(key));

//        for (String value : capitals.values()) {
//            System.out.println("Capital: " + value);
//        }

        for (Map.Entry<String, String> entry : capitals.entrySet()) { //Entry это пара из ключа и значения
            System.out.println("Entry key: " + entry.getKey() + " value: " + entry.getValue());
        }

        capitals.remove("France"); // удаление отображения по ключу

        List<Integer> numbers = Arrays.asList(1, 2, 1, 4, 4, 5, 4, 7, 1);

        countNumbers(numbers);

        Map<String, String> aero = new HashMap<>();
        aero.put("Berlin", "London");
        aero.put("Tokyo", "Seoul");
        aero.put("Mumbai", "Berlin");
        aero.put("Seoul", "Mumbai");

        findTicket("Tokyo", "Berlin", aero);

        List<String> words = Arrays.asList("hello", "hi", "nice", "hell");

        // {
        //  "h" -> {"hello", "hi", "hell"},
        //  "n" -> {"nice"}
        //  }

        System.out.println(findWords(words));
    }

    // вернуть map где ключом будет первая буква слова
    // с значением список всех слов где она является первой буквой
//    public static Map<String, Set<String>> findWords(List<String> words) {
//        Map<String, Set<String>> result = new HashMap<>();
//
//        for (String word : words) {
//            String firstLetter = word.substring(0, 1);
//            Set<String> wordList = result.getOrDefault(firstLetter, new HashSet<>());
//            wordList.add(word);
//            result.put(firstLetter, wordList);
//        }
//
//        return result;
//    }

    public static Map<String, Set<String>> findWords(List<String> words) {
        Map<String, Set<String>> result = new HashMap<>();
        for (String w : words) {
            String key = w.substring(0, 1);
            Set<String> value = result.get(key);
            if (value == null) {
                value = new HashSet<>();
            }
            value.add(w);
            result.put(key,value);
        }
        return result;
    }





    // напишите функцию, которая подбирает человеку сложный билет
    public static void findTicket(String first, String last, Map<String, String> db)
    {
        String current = first; // текущий аэропорт
        String next = ""; // следующий
        while (current != null && !current.equals(last))
        {
            next = db.get(current);
            System.out.println(current + "->" + next);
            current = next;
        }
    }





    //    public static void countNumbers(List<Integer> ints) {
//        Map<Integer, Integer> counter = new HashMap<>();
//
//        for(int i : ints)
//            counter.put(i, counter.getOrDefault(i, 0) + 1);
//
//        for(int num : counter.keySet())
//            System.out.printf("%d встречается %d раз(а)\n", num, counter.get(num));
//
//    }
    public static void countNumbers(List<Integer> ints) {
        Map<Integer, Integer> counter = new TreeMap<>();
        //TreeMap хранит все свои пары ключей по возрастанию
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
        for(int i: counter.keySet())
        {
            System.out.println("number: " + i + " count: " + counter.get(i));
        }
}

}
