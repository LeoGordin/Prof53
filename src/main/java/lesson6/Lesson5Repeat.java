package lesson6;

import java.util.Arrays;

public class Lesson5Repeat {
    public static void main(String[] args) {
        int[] [] d = {
                {1, 3, 5},
                {10, 20},
                {-1}
        };

        System.out.println(Arrays.toString(flattening(d)));

    }
    // напишите функцию уплощения двухмерного массива
    // задача в том чтобы возвратить одномерный массив
    // со всеми элементами двухмерного
    public static int [] flattening(int [][] a)
    {
        // пробежаться по двухмерному массиву и узнать общее количество элементов
        int n = 0;
        for (int i = 0; i < a.length; i++)
        {
            n += a[i].length;
        }

        // создать одномерный массив с этим количеством
        // в еще одном ? цикле добавить в него элементы из двухмерного

        int [] r = new int[n];

        int position = 0;

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                r[position++] = a [i][j];
            }
        }

        return r;


    }


}
