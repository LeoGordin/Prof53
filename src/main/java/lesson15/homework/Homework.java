package lesson15.homework;

import org.w3c.dom.ls.LSException;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("one", "two", "three", "two", "four", "four");
        System.out.println(
                getDuplicatesFromList(words)
        );

        System.out.println(
                getUniqueLetters("student")
        );
        System.out.println(
                getUniqueLetters("students")
        );

        List<String> w = Arrays.asList("student", "students", "dog", "god", "cat", "act", "flow", "wolf");
        System.out.println(getUniqueWordsList(w));
    }

    // Сгруппируйте элементы списка по уникальному набору символов
    public static Map<String, List<String>> getUniqueWordsList(List<String> strings)
    {
        Map<String, List<String>> result = new LinkedHashMap<>();
        for(String s: strings)
        {
            String key = getUniqueLetters(s);
            List<String> now = result.get(key);
            if(now == null)
                now = new ArrayList<>();
            now.add(s);
            result.put(key, now);
        }
        return result;
    }

    public static String getUniqueLetters(String string)
    {
        Set<String> key = new TreeSet<>();
        for(String s: string.split(""))
        {
            key.add(s);
        }
        return key.toString();
    }



    public static Map<String, Integer> getDuplicatesFromList(List<String> strings)
    {
        Map<String, Integer> result = new HashMap<>();
        for(String s: strings)
        {
            Integer number = result.get(s);
            if(number == null) // слово новое, пока не встречалось
                result.put(s, 1);
            else
                result.put(s, number+1);
        }
        return result;
    }
}
