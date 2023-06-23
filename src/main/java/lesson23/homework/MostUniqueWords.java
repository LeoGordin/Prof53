package lesson23.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MostUniqueWords {
    public static void main(String[] args) {
        String filePath = "employee.txt";

        Set<String> uniqueWords = findUniqueWords(filePath);

        System.out.println("Unique words:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }

    private static Set<String> findUniqueWords(String filePath) {
        Set<String> uniqueWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                Collections.addAll(uniqueWords, words);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());;
        }
        return uniqueWords;
    }
}

