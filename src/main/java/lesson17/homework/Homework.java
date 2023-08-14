package lesson17.homework;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {

        System.out.println(encode("aaaabbccc")); // 4a2b3c
        System.out.println(decode("4a2b3c"));  // aaaabbccc

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(                     // 0 1 2 3 4
                countSumOfLast(2, numbers)
        );

        int numberToSkip = numbers.size() - Math.max(0, numbers.size() - 2 - 1);

        System.out.println(
                numbers.stream().skip(numberToSkip).reduce(0, (acc, i) -> acc + i)
        );

        // Элементы списка строк преобразуйте в верхний регистр и добавьте к длину;
        // потом вызовите функцию которая преобразует строки в обратный порядок
        // Пример: ["Dima", "Max"] -> ["4-AMID", "3-XAM"]
        List<String> names = Arrays.asList("Dima", "Max");
        System.out.println(
                names.stream()
                        .map(String::toUpperCase)
                        .map(s -> s + "-" + s.length())
                        .map(StringBuilder::new)
                        .map(StringBuilder::reverse)
                        .map(StringBuilder::toString)
                        .collect(Collectors.toList())
        );
    }


    // напишите функцию которая возвращает сумму N последних элементов списка целых
    // пример 2 , {1,2,3,4,5} ->  9
    static int countSumOfLast(int n, List<Integer> list) {
        int minNumber = Math.max(0, list.size() - n);
        int sum = 0;
        for (int i = minNumber; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }


    // написать декодер
    // 4a2b3c -> aaaabbccc
    public static String decode(String s) {
        StringBuilder r = new StringBuilder();
        String d = ""; // сюда сохраняем цифры
        char[] letters = s.toCharArray();
        for (char c : letters) {
            if (!Character.isDigit(c)) {
                int numberOfLetters = Integer.parseInt(d);
                for (int j = 0; j < numberOfLetters; j++)
                    r.append(c);
                d = "";
            } else {
                d += c;
            }
        }
        return r.toString();
    }

    // строка состоит только из маленьких букв - например - aaaabbccc
    // закодировать 4a2b3c
    public static String encode(String s) {
        StringBuilder b = new StringBuilder(); // сюда будет сохраняться резултат кодирования
        char[] letters = s.toCharArray();
        int counter = 0; // сколько текущих букв встретилось
        char prev = letters[0]; // предыдущая буква
        char curr = letters[0]; // текущая буква
        for (char c : letters) {
            curr = c;
            if (curr != prev) {
                b.append(counter).append(prev);
                counter = 1;
            } else {
                counter++;
            }
            prev = curr;
        }
        b.append(counter).append(curr);
        return b.toString();
    }
}
