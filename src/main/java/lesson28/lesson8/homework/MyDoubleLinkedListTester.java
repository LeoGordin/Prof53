package lesson28.lesson8.homework;

public class MyDoubleLinkedListTester {
    public static void main(String[] args) {
        MyDoubleLinkedList l = new MyDoubleLinkedList();
        l.add(1);
        l.add(2);
        l.add(5);
        System.out.println(l);
        System.out.println(l.size());
        System.out.println(l.get(0));
        System.out.println(l.get(1));

        System.out.println(l.contains(5));
        System.out.println(l.contains(10));
        l.set(2, 10);
        System.out.println(l);

        l.add(1, 15);
        System.out.println(l);

        l.remove(2);
        System.out.println(l);
    }
}
