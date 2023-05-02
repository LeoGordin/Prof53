package lesson8.homework;

public class MyDoubleLinkedListTester {
    public static void main(String[] args) {
        MyDoubleLinkedList l = new MyDoubleLinkedList();
        l.add(1);
        l.add(2);
        l.add(5);
        System.out.println(l);
        System.out.println(l.size());
        l.add(0,4);
        System.out.println(l.get(1));
        System.out.println(l);
        l.set(1, 11);
        System.out.println(l);
        l.remove(0);
        System.out.println(l);
    }
}
