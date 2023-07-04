package lesson26.homework;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                format(
                        Arrays.asList("Dima", "Max", "Alena"), "|"
                )
        );

        System.out.println(
                getExtension("hello.png") // png
        );
        System.out.println(
                getExtension("my.resume.1.doc") // doc
        );

        System.out.println(isPinCode("1234"));
        System.out.println(isPinCode("123456"));
        System.out.println(isPinCode("12345"));
        System.out.println(isPinCode("aabbcc"));
        System.out.println(isPinCode("1234567"));
        System.out.println(isPinCode("1a2b3c4e5d67"));

        System.out.println(replaceAllVowels("London is a capitAl of GREAT BRITAIN"));

        System.out.println(mapAllIntsToDouble(" 1 расходы 20 доходы 50.3 3"));
    }
    // Напишите функцию которая бы принимала на вход список строк и
    // форматировала их, добавляя разделитель между элементами
    public static String format(List<String> strings, String delimiter) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            if(i != 0)
                b.append(delimiter);
            b.append(strings.get(i));
        }
        return b.toString();
    }

    // Напишите функцию возвращающую расширение передаваемого в нее имени файла.
    // Расширение это то что после последней точки
    // "hello.png" -> "png"
    // "my.resume.1.doc" -> "doc"
    public static String getExtension(String filename)
    {
        Pattern p = Pattern.compile("[^\\.]+$");
        Matcher m = p.matcher(filename);
        if(m.find())
            return m.group();
        return null;
    }

    public static boolean isPinCode (String pin) {
        return pin.matches("\\d{4}|\\d{6}");
    }

    // Напишите функцию, удаляющую из строки все гласные в любом регистре
    public static String replaceAllVowels(String string) {
        return string.replaceAll("[aeiouyAEIOUY]", "");
    }

    // Если в строке встречается целое число, отделенное пробелами,
    // то добавьте этому числу ".0"
    // Пример: "расходы 20 доходы 50.3" -> "расходы 20.0 доходы 50.3"
    public static String mapAllIntsToDouble(String s)
    {
        //  $1   $2   $3     $1    $2 + ".0" + $3
        // " " + 20 + " " -> " " + 20.0 +     " "
        return s.replaceAll("(\\s|^)(\\d+)(\\s|$)", "$1$2.0$3");
    }
}
