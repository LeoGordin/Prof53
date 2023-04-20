package lesson5.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class SortTester {

    public static void main(String[] args) {

        String[] countries = new String[]{
                "France",
                "Cyprus",
                "Germany",
                "Burkina-Faso",
                "Switzerland",
        };

        Arrays.sort(countries);


        int[] a = new int[]{1, -10, 2, 5, 3};
        Arrays.sort(a);
        System.out.println(
                Arrays.toString(a)
        );

        Arrays.sort(countries, new StringLengthComparator());
        System.out.println(Arrays.toString(countries));

        int [] a1 = {1,2,3};
        int [] b1 = {1,2,3};
        System.out.println(compare(a1, b1));


    }

    // binarySearch возвращает отрицательное число если такого элемента в контейнере нет
    // либо порядковый номер найденного элемента

    // напишите функцию которая получает на вход два массива целых одинаковой длины
    // возвращает true если элементы массивов совпадают
    public static boolean compare(int [] a, int [] b)
    {
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] != b[i])
                return false;
        }
        return true;
    }

}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2){

        return o1.length() - o2.length();
    }
}