package lesson17.homework;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/*
Элементы списка строк преобразуйте в верхний регистр и добавьте к длину;
потом вызовите функцию которая преобразует строки в обратный порядок
Пример: ["Dima", "Max"] -> ["4-AMID", "3-XAM"]
 */

public class Homework {

    public static void main(String[] args) {
        List<String> inputStrings = Arrays.asList("Dima", "Max");

        List<String> transformedStrings = transformStrings(inputStrings);
        System.out.println(transformedStrings);

        List<String> reversedStrings = reverseStrings(transformedStrings);
        System.out.println(reversedStrings);
    }
    public static List<String> transformStrings(List<String> strings) {
        Function<String, String> transformFunction = str -> str.length() + "-" + str.toUpperCase();
        return mapStrings(strings, transformFunction);
    }

    public static List<String> reverseStrings(List<String> strings) {
        UnaryOperator<String> reverseFunction = str -> new StringBuilder(str).reverse().toString();
        return mapStrings(strings, reverseFunction);
    }

    private static List<String> mapStrings(List<String> strings, Function<String, String> mappingFunction) {
        return strings.stream()
                .map(mappingFunction)
                .toList();
    }
}