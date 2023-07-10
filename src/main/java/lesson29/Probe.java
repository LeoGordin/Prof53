package lesson29;

import java.util.Arrays;

public class Probe {
    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4, 5, 6, -6, -4, -3, -2};
        int [] b = {1, 2, 3, 4, 5, 6};
        int[] c = {};

        System.out.println(maxOfArray(a));
        System.out.println(maxOfArray(b));
        //System.out.println(maxOfArray(c));
        System.out.println(isOnlyPositive(a));
        System.out.println(isOnlyPositive(b));

    }
    public static int maxOfArray (int [] a) {
        return Arrays.stream(a).max().orElse(0);
    }

    public static boolean isOnlyPositive (int [] a) {
        return Arrays.stream(a).allMatch(i -> i > 0);
    }
}
