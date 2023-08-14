package lesson9.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Countries {
    public static void main(String[] args) {
        Set<String> countries = new HashSet<>(
                Arrays.asList(
                        "Andorra", "Belize", "France", "Argentina", "Cuba", "Sweden"
                )
        );

        Set<String> words = new HashSet<>(
                Arrays.asList("Andorra", "Canada", "wood", "parrot", "Cuba", "Argentina", "Aruba", "Alex", "Finland")
        );
        // Нужно получить список всех стран из списка слов, начинающихся на "A" -
        // [Andorra, Argentina]

        Set<String> tempWords = new HashSet<>(words);

        Iterator<String> wordsIterator = tempWords.iterator();
        while (wordsIterator.hasNext())
        {
            String word = wordsIterator.next();
            if(!word.startsWith("A"))
                wordsIterator.remove();
        }

        System.out.println(tempWords);

        countries.retainAll(tempWords);
        // пересечение
        // оставляет в коллекции countries только те элементы
        // которые присутствуют и в коллекции words

        System.out.println(countries);

    }
}
