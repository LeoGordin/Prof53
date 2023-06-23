package lesson23.homework;

import java.io.BufferedReader;
import java.io.FileReader;

public class LongestWord {

        public static void main(String[] args) {

            String filePath = "matches.txt";

            String longestWord = findLongestWord(filePath);

            System.out.println(longestWord);
        }

        private static String findLongestWord(String filePath) {
            String longestWord = "";

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if (word.length() > longestWord.length()) {
                            longestWord = word;
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());;
            }

            return longestWord;
        }
}
