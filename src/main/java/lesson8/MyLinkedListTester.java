package lesson8;

public class MyLinkedListTester {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);

        System.out.println(list.size());
        list.set(2, 30);
        System.out.println(list);

        System.out.println(list.get(1));

        list.add(0, -10);
        System.out.println(list);

        list.add(3, 20);
        System.out.println(list);
        list.add(0, 18);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        System.out.println(list.getFirst()); // 1
        list.addFirst(-10);
        System.out.println(list);

        System.out.println(list.removeFirst()); // -10
        System.out.println(list);


    }
}
