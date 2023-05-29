package lesson15;

import java.util.*;

public class Homework {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Audi", "Bentley", "Porsche", "Audi", "Bentley", "Bentley");
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


        String[] words = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};
        Map<String, List<String>> groupedWords = groupByUniqueCharacters(words);

        // Вывод результатов
        for (Map.Entry<String, List<String>> entry : groupedWords.entrySet()) {
            System.out.println("Набор символов: " + entry.getKey());
            System.out.println("Элементы списка: " + entry.getValue());
            System.out.println();
        }
    }


        public static Map<String, List<String>> groupByUniqueCharacters (String[] words){
            Map<String, List<String>> groupedWords = new HashMap<>();

            for (String word : words) {
                String sortedChars = sortCharacters(word);

                if (groupedWords.containsKey(sortedChars)) {
                    groupedWords.get(sortedChars).add(word);
                } else {
                    List<String> newList = new ArrayList<>();
                    newList.add(word);
                    groupedWords.put(sortedChars, newList);
                }
            }

            return groupedWords;
        }

        public static String sortCharacters (String word){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }



