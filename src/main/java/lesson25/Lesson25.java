package lesson25;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson25 {
    public static void main(String[] args) {
        // 1. проверка соответствия строки шаблону
        // max.kotkov@gmail.com
        // +1-112-345-33-44
        // 2. разбиение строки по регулярному выражению
        // max |kotkov  |  24   |married
        // 3. замена
        // max kotkov -> Max Kotkov

        // классы - Pattern, Matcher ...
        String string = "this is a max temperature and it was a real maximum";
        // Pattern - скомпилированное регулярное выражение
        // используется для ускорения поиска
        Pattern max = Pattern.compile("max");
        // класс используемый для поиска совпадений в кокретной строке
        Matcher maxMatcher = max.matcher(string);
        while (maxMatcher.find())
        {
            System.out.println("s: " +maxMatcher.start() + " e: " + maxMatcher.end() + " " + maxMatcher.group());
        }

        String telran = "www.telran.de";

        System.out.println(".*");
        Pattern telranPattern = Pattern.compile(".*www.*");
        System.out.println(
                telranPattern.matcher(telran).matches()
        );

        // проверка нахождения шаблона в строке без компиляции шаблона
        System.out.println(Pattern.matches(".*www.*", telran));

        System.out.println("hello".matches("hel.*"));
        System.out.println("hello".matches("hel.."));

        System.out.println("| - альтернатива");
        System.out.println("max".matches("max|dima")); // либо одно либо другое
        System.out.println("maxmasha".matches("max|dima")); // либо одно либо другое

        System.out.println("() - группировка");
        System.out.println("maxmasha".matches("(max|dima).*"));

        System.out.println("[] - перечисление");

        System.out.println("a".matches("[abcdef]")); // любой один из перечисленных символов

        System.out.println("abc".matches("[abcdef]*"));
        System.out.println("abc".matches("[abcdef]{3}")); // три символа из перечисления
        System.out.println("abc".matches("[a-f]{3}")); // три символа из перечисления

        System.out.println("[^] - отрицание");
        System.out.println("a".matches("[^klm]")); // любой символ кроме k, l и m
        System.out.println("a".matches("[^k-m]")); // любой символ кроме k, l и m

        System.out.println("+ \\s"); // + значит 1 и более раз
        // \\s - любой пробельный символ
        System.out.println(
                "max kotkov".matches("[a-z]+\\s[a-z]+")
        );

        System.out.println("Max    Kotkov".matches("[A-Z][a-z]+\\s+[A-Z][a-z]+"));
        // большая буква + несколько маленьких + несколько пробелов + большая буква + несколько маленьких

        // квантификаторы
        // * - нуль и более
        // + - один и более
        // ? - нуль или один
        // {3} - ровно три
        // {2,} - два и более
        // {7,10} - от 7 до 10

        // специальные символы
        // \\d - любая цифра [0-9]
        // \\s - пробельный символ

        System.out.println("isHexNumber");
        System.out.println(isHexNumber("0x1")); // true
        System.out.println(isHexNumber("0X12")); // true
        System.out.println(isHexNumber("0XABc")); // true
        System.out.println(isHexNumber("0x12345")); // true
        System.out.println(isHexNumber("0xABW")); // false
        System.out.println(isHexNumber("12")); // false

        System.out.println("isPhoneNumber");
        System.out.println(isPhoneNumber("+1")); // true
        System.out.println(isPhoneNumber("+34")); // true
        System.out.println(isPhoneNumber("915")); // true
        System.out.println(isPhoneNumber("+a12")); // false
        System.out.println(isPhoneNumber("+112a1")); // false
        System.out.println(isPhoneNumber("++12")); // false
        System.out.println(isPhoneNumber("a123")); // false
        System.out.println(isPhoneNumber("1234567890")); // false

        System.out.println("isIpV4Address");
        System.out.println(isIpV4Address("0.0.0.0")); // true
        System.out.println(isIpV4Address("255.255.255.255")); // true
        System.out.println(isIpV4Address("10.10.10.10")); // true
        System.out.println(isIpV4Address("1.1.a.255")); // false
        System.out.println(isIpV4Address("1.1")); // false
        System.out.println(isIpV4Address("1.1.1.300")); // false

        System.out.println("разбиение");
        String line = "to   be or      not to    be";
        System.out.println(
                Arrays.toString(
                        line.split("\\s+")
                )
        );

        String strangeLine = "michael;levanov|34|12.55";
        // разбить по ; и по | и распечатать массив
        System.out.println(
                Arrays.toString(
                        strangeLine.split(";|\\|")
                )
        );


        System.out.println("группировка");

        String people = "Max Semenov    Lena Petrova         Igor Semin";
        Pattern firstLastNamePattern = Pattern.compile("(\\w+)\\s+(\\w+)");
        // \\w - символ который может встречаться в слове - буква
        Matcher namesMatcher = firstLastNamePattern.matcher(people);
        while (namesMatcher.find())
        {
            System.out.println("name: " + namesMatcher.group(1) + " lastname: " + namesMatcher.group(2));
        }

        System.out.println("замена");
        String temperature = "Today's temperature is 18 degrees centigrade";

        temperature = temperature.replaceAll("\\d+", "45");
        temperature = temperature.replaceAll("centi", "mili");
        System.out.println(temperature);

        String numbers = "one two eight twenty";
        numbers = numbers.replaceAll("(tw\\w+)", "_$1_");
        // $1 это ссылка на значение первой группы
        System.out.println(numbers);


    } // окончание main


    // 10.12.34.211 каждая цифра от 0 до 255
    // 333.2.33.1
    public static boolean isIpV4Address(String a)
    {                              // 166   239       25
        String octet = "(\\d|\\d{2}|1\\d{2}|2[0-4]\\d|25[0-5])";
        String template = octet + "\\." + octet + "\\." + octet + "\\." + octet;
        return a.matches(template);
    }


    public static boolean isPhoneNumber(String n)
    {
        // опциональный + вначале  \\+
        // дальше от 1 до 8 цифр
        return n.matches("\\+?\\d{1,8}");
    }

    public static boolean isHexNumber(String h)
    {
        // префикс либо 0x либо 0X
        // дальше неограниченное количество 16-ричных цифр
        // 0123...9abc..fA...F
        // [1-3a-c]
        return h.matches("0[xX][0-9a-fA-F]+");
    }
}
