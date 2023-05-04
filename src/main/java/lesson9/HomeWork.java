package lesson9;

//1. Дописать функции в DoubleLinkedList
//2. Есть список стран [Andorra, Belize, France, Argentina, Cuba, Sweden] и список слов [Andorra, Canada, wood, parrot, Cuba, Argentina, Aruba, Alex, Finland]
//Нужно получить список всех стран из списка слов, начинающихся на "A" - [Andorra, Argentina]

import java.util.HashSet;
import java.util.Set;

public class HomeWork {
    public static void main(String[] args) {

        Set<String> countries = new HashSet<>();
        countries.add("Andorra");
        countries.add("Belize");
        countries.add("France");
        countries.add("Argentina");
        countries.add("Cuba");
        countries.add("Sweden");


        Set<String> words = new HashSet<>();
        words.add("Andorra");
        words.add("Canada");
        words.add("wood");
        words.add("parrot");
        words.add("Cuba");
        words.add("Argentina");
        words.add("Aruba");
        words.add("Alex");
        words.add("Finland");

        Set<String> letterACountriesInWords = new HashSet<>();

        for (String w : words) {
            if (countries.contains(w) && w.startsWith("A")) {
                letterACountriesInWords.add(w);
            }
        }

        System.out.println(letterACountriesInWords);
    }
}
