package lesson10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
        String sentence = "два раза это два раза";
        // до 21:15
        /*
            два:2
            раза:2
            это:1
         */

        System.out.println(countWords(sentence));

    }

    // напишите функцию которая распечатает сколько раз каждое из слов встретилось во фразе

    public static HashSet<Word> countWords(String s)
    {
        HashSet<Word> words = new HashSet<>();
        for(String w : s.split(" "))
        {
            Word word = new Word(w);
            // если слово word уже есть в words,
            if(words.contains(word))
            {
                // получим его из сета и увеличим count на 1
                word = findWord(words, word);
            }
            word.count++;
            // если слова нет то добавим
            words.add(word);
        }
        return words;
    }

    // поиск слова перебором в наборе слов
    public static Word findWord(Set<Word> words, Word sample)
    {
        for(Word w: words)
        {
            if(w.equals(sample))
                return w;
        }
        return null;
    }

    static class Word {
        public String key;
        public int count = 0;

        public Word(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key + ":" + count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Word word = (Word) o;

            return key.equals(word.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }
}
