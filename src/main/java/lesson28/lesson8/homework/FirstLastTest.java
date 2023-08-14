package lesson28.lesson8.homework;

public class FirstLastTest {
    public static void main(String[] args) {
        MyDoubleLinkedList l = new MyDoubleLinkedList();
        l.addLast(20);
        l.addFirst(10);
        System.out.println(l); // 10 20
        System.out.println(l.getFirst()); // 10
        System.out.println(l.getLast()); // 20
        System.out.println(l.removeFirst()); // 10
        System.out.println(l.removeLast()); // 20
        System.out.println(l);
    }
}
