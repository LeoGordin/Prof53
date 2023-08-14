package lesson28.lesson8.homework;

import lesson6.list.MyList;

public class MyDoubleLinkedList implements MyList {

    private int size = 0;
    private Node head;
    private Node tail;

    public int getFirst() {
        return get(0);
    }

    public int getLast() {
        return get(size() - 1);
    }

    public int removeFirst() {
        int temp = get(0);
        remove(0);
        return temp;
    }

    public int removeLast() {
        int temp = get(size() - 1);
        remove(size() - 1);
        return temp;
    }

    public void addFirst(int value) {
        add(0, value);
    }

    public void addLast(int value) {
        add(value);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node n = getNodeByIndex(index);
        return n.value;
    }

    private Node getNodeByIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node n = head;
        while (n != null && index > 0) {
            index--;
            n = n.next;
        }
        return n;
    }

    @Override
    public boolean contains(int value) {
        Node n = head;
        while (n != null) {
            if (n.value == value)
                return true;
            n = n.next;
        }
        return false;
    }

    @Override
    public void set(int index, int value) {
        Node n = getNodeByIndex(index);
        if (n != null)
            n.value = value;
    }

    @Override
    public void add(int value) {
        Node node;
        // нет ни одного элемента
        if (size() == 0) {
            node = new Node(value);
            head = node;
        } else {
            node = new Node(null, tail, value);
        }
        tail = node;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("[");
        Node n = head;
        while (n != null) {
            b.append(n.value);
            if (n.next != null)
                b.append(", ");
            n = n.next;
        }
        b.append("]");
        return b.toString();
    }

    @Override
    public void add(int index, int value) {
        if (size() == 0 && index == 0) {
            add(value);
            return;
        }
        if (index == 0) {
            Node n = new Node(head, null, value);
            head = n;
        } else if (index == size()) {
            Node n = new Node(null, tail, value);
            tail = n;
        } else {
            Node n = getNodeByIndex(index);
            Node p = n.prev;
            Node newNode = new Node(n, p, value);
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        if (index == 0 && head != null) {
            head = head.next;
            if (head != null)
                head.prev = null;
        } else if (index == size() - 1) {
            tail = tail.prev;
            if (tail != null)
                tail.next = null;
        } else {
            Node c = getNodeByIndex(index);
            Node p = c.prev;
            Node n = c.next;
            if (p != null)
                p.next = n;
            if (n != null)
                n.prev = p;
        }
        size--;
    }


    private static class Node {
        Node prev;
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next, Node prev, int value) {
            this.next = next;
            this.value = value;
            this.prev = prev;
            if (next != null)
                next.prev = this;
            if (prev != null)
                prev.next = this;
        }

    }
}
