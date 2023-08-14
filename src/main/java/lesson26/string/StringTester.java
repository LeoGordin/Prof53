package lesson26.string;

import java.util.Random;

public class StringTester {
    public static void main(String[] args) {
        String max = "Max";
        String anotherMax = "Max";
        System.out.println(anotherMax == max); //


        String newMax = max;

        // == для объектов сравнивает их адрес в памяти
        // .equals() сравнивает объекты по значению
        System.out.println(max == newMax); // true

        max += " Kotkov";
        System.out.println(max == newMax); // false


        // ВСЕГДА при изменении строки создается новая строка
        // НИКОГДА МАССОВО НЕ КОНКАТЕНИРУЙТЕ СТРОКИ


        StringBuilder maxBuilder = new StringBuilder("Max");

        StringBuilder anotherMaxBuilder = maxBuilder;
        System.out.println("anotherMaxBuilder == maxBuilder: " + (anotherMaxBuilder == maxBuilder)); // true
        maxBuilder.append(" Kotkov");
        System.out.println("anotherMaxBuilder == maxBuilder: " + (anotherMaxBuilder == maxBuilder)); // true

        System.out.println(maxBuilder.toString());

//        for(int i = 0; i < 10; i++)
//        {
//            addManyDoublesUsingString(); // 9000 милисекунд
//        }
        for(int i = 0; i < 10; i++)
        {
            addManyDoublesUsingStringBuilder(); // 37 милисекунд
        }

        // ВСЕГДА используйте StringBuilder для работы с большим количеством строк

        // потокобезопасная реализация StringBuilder
        // чуть медленнее чем StringBuilder
        StringBuffer buffer = new StringBuffer();


    } // окончание main

    public static void addManyDoublesUsingStringBuilder()
    {
        long before = System.currentTimeMillis(); // возвращает количество милисекунд с 1 января 1970
        StringBuilder r = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 100_000; i++)
        {
            r.append(random.nextDouble());
        }
        long after = System.currentTimeMillis();
        System.out.println("addManyDoublesUsingStringBuilder: " + (after - before));
    }

    public static void addManyDoublesUsingString()
    {
        long before = System.currentTimeMillis(); // возвращает количество милисекунд с 1 января 1970
        String r = "";
        Random random = new Random();
        for(int i = 0; i < 100_000; i++)
        {
            r += random.nextDouble();
        }
        long after = System.currentTimeMillis();
        System.out.println("addManyDoublesUsingString: " + (after - before));
    }

}
