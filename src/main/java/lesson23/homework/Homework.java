package lesson23.homework;

import lesson2.crossword.B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        try (
                FileReader fr = new FileReader("words.txt");
                BufferedReader br = new BufferedReader(fr);
        ) {
            Set<String> words =
                    br.lines()
                            .flatMap(string -> Arrays.stream(string.split(" ")))
                            .collect(
                                    Collectors.toSet()
                            );

            Set<String> sortedWords = new TreeSet<>();
            sortedWords.addAll(words);

            System.out.println(sortedWords);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


        try (
                FileReader fr = new FileReader("words.txt");
                BufferedReader br = new BufferedReader(fr);

        ) {
            System.out.println(
                    br.lines()
                            .flatMap(string -> Arrays.stream(string.split(" ")))
                            .max(Comparator.comparingInt(String::length))
                            .orElse("")
            );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
