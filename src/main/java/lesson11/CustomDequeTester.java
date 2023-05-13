package lesson11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class CustomDequeTester {
    public static void main(String[] args) {

        CustomDeque customDeque = new CustomArrayDeque();
        customDeque.addFirst(1);
        customDeque.addFirst(2);
        customDeque.addFirst(3);
        customDeque.addFirst(4);
        System.out.println(customDeque);
        System.out.println(customDeque.getLast());
        System.out.println(customDeque.getFirst());
        customDeque.removeLast();
        System.out.println(customDeque.getLast());
        System.out.println(customDeque);
        customDeque.addLast(5);
        System.out.println(customDeque);
    }
}
