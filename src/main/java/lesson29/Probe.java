package lesson29;

import java.util.Arrays;

public class Probe {
    public static int maxOfArray(int [] a)
    {
        // вернуть максимум массива
        return Arrays.stream(a).max().orElse(0);
    }

    public static boolean isOnlyPositive(int [] a)
    {
        // вернуть true если в массиве только положительные числа
        return Arrays.stream(a).allMatch(i -> i > 0);
    }
}
