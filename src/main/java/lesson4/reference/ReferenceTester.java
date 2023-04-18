package lesson4.reference;

import java.util.Arrays;

public class ReferenceTester {
    public static void main(String[] args) {
        // примитивные типы данных начинаются на маленькую букву (int, double, byte, char, long, short, float, boolean)
        // Ссылочные типы данных начинаются на заглавную букву (String, Integer, Double etc)

        int a[] = new int[1];
        a[0] = 10;
        changeArray(a);
        System.out.println(a[0]);

    }

    public static void changeArray( int [] array){
        array[0] = 1_000;
    }
}
