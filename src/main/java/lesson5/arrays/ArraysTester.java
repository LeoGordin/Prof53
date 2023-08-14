package lesson5.arrays;

import java.util.Arrays;

public class ArraysTester {
    public static void main(String[] args) {
        int[] a = new int[]{1, 7, 5, 3, -20};
        int[] b = new int[2]; // проинициализируются значениями по-умолчанию

        String [] movies = new String[] {"Apocalypse now", "Taxi Driver", "Tango and Cache"};

        String [] songs = {"Rasputin", "Never let me down again"};

        test(new String[] {"abc"});
        test(songs);
        // test({"abc"});

        System.out.println(a.length);
        System.out.println(songs);
        System.out.println(
                Arrays.toString(songs)
        );
        songs[1] = "November rain";
        System.out.println(
                Arrays.toString(songs)
        );
        System.out.println(
                format(movies)
        );

        System.out.println(
                format(movies, "<", ">", "|")
        );


        int [] [] c = new int[][] {
                {1,   3,   5},   // 0
                {4},             // 1
                {-10, 20, -40, 5}// 2
        };

        System.out.println(c[2][2]); // распечатать элемент со значением -40

        System.out.println(c.length); // 3
        System.out.println(c[2].length); // 4

        String [][] names = new String[2][3];
        String [][] countries = new String[2][];

        System.out.println(
                Arrays.toString(
                        concatenate(
                                new int[] {1,2,3},
                                new int[] {4,5,6,7}
                        )
                )
        );

        // перерыв до 20:55
    }

    // напишите функцию которая принимает на вход два массива целых любой длины и
    // возвращает новый массив целых суммарной длины с элементами
    // взодных массивов [1,2,3], [4,5,6] -> [1,2,3,4,5,6]
    public static int [] concatenate(int [] a, int [] b)
    {
        int  [] c = new int[a.length + b.length];
        int counter = 0;
        for (int j : a) {
            c[counter++] = j;
        }
        for (int j : b) { // [4,5,6]
            c[counter++] = j;
        }
        return c;
    }


    public static String format(String [] s) {
        // [Rasputin, Never let me down again]
        String result = "";
        result += "[";
        for (int i = 0; i < s.length; i++)
        {
            if(i != 0)
            {
                result += ", ";
            }
            result += s[i];
        }
        result += "]";
        return result;
    }


    public static String format(String [] s, String prefix, String suffix, String delimiter) {
        // [Rasputin, Never let me down again]
        StringBuilder result = new StringBuilder(prefix);
        for (int i = 0; i < s.length; i++)
        {
            if(i != 0)
            {
                // result += ", ";
                result.append(delimiter);
            }
            // result += s[i];
            result.append(s[i]);
        }
        // result += "]";
        result.append(suffix);
        // return result;
        return result.toString();
    }

    public static void test(String [] s)
    {

    }
}























