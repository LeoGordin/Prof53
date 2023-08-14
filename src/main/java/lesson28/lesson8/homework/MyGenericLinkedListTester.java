package lesson28.lesson8.homework;

import lesson28.lesson8.MyGenericLinkedList;

public class MyGenericLinkedListTester {
    public static void main(String[] args) {
        MyGenericLinkedList<String> l = new MyGenericLinkedList<>();

        l.add("hello");
        l.add(0, "world");
        l.add(1, "ace");

        System.out.println(l);
        l.remove(2);
        System.out.println(l);
    }
}
