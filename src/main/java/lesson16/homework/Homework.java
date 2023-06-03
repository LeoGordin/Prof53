package lesson16.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework {
    /* ДЗ проф ява
строка состоит только из маленьких букв - например - aaaabbccc
закодировать 4a2b3c
написать декодер
напишите функцию которая возвращает сумму N последних элементов списка целых
int countSumOfLast(int n, List<Integer> list)
2 , {1,2,3,4,5} ->  9
     */

    public static void main(String[] args) {
        String s1 = encodeString("aaaaaaaaabbbbbbbbccccccdddddffffff");

        System.out.println(s1);

        String s2 = decodeString(s1);

        System.out.println(s2);

        List<Integer> testList = new ArrayList<>(Arrays.asList(1,3,5,6,7,8,9,8,7,6));

        System.out.println(countSumOfLast(3, testList));

    }

    public static String encodeString(String input) {
        StringBuilder encodedString = new StringBuilder();
        int count = 1;

        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                encodedString.append(count).append(input.charAt(i));
                count = 1;
            }
        }

        return encodedString.toString();
    }

    public static String decodeString(String input) {
        StringBuilder decodedString = new StringBuilder();
        int count = 0;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else {
                for (int i = 0; i < count; i++) {
                    decodedString.append(c);
                }
                count = 0;
            }
        }

        return decodedString.toString();
    }

    public static int countSumOfLast(int n, List<Integer> list) {
        int sum = 0;
        int size = list.size();

        for (int i = size - 1; i >= Math.max(0, size - n); i--) {
            sum += list.get(i);
        }

        return sum;
    }

}
