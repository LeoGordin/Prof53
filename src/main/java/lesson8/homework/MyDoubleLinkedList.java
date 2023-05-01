package lesson8.homework;

import lesson6.list.MyList;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyDoubleLinkedList implements MyList {

    private int size = 0;
    private Node head;
    private Node tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }
    }

    @Override
    public boolean contains(int value) {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Node current = head;
        while(current != null && current.value != value) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        return true;
    }



    @Override
    public void set(int index, int value) {
        remove(index);
        add(index, value);
    }



    @Override
    public void add(int value) {
        Node n = new Node(value);
        if (head == null)
        {
            head = tail = new Node(value);
            head.prev = null;
            tail.next = null;
        }
        else {
            tail.next = new Node(value);
            n.prev = tail;
            tail = n;
            tail.next = null;
        }
    }

    @Override
    public void add(int index, int value) {
    if (index >=0 && index <= size) {
        Node n = new Node(value);
        Node current = head;
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            for (int i = 0; i < index && current.next != null; i++) {
                current = current.next;
            }
            n.next = current;
            current.prev.next = n;
            n.prev = current.prev;
            current.prev = n;
            size++;
        }
    }else {
        throw new IndexOutOfBoundsException();
    }


    }

    @Override
    public void remove(int index) {
        if (index+1 >= 0 && index+1 <= size) {
            Node node = head;

            if (index == 0) {
                removeFirst();
            } else if (index == size - 1) {
                removeLast();
            } else {
                for (int i = 0; i < index && node.next != null; i++){
                    node = node.next;
                }
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int getFirst() {
        return get(0);
    }

    public int getLast() {
        return get(size-1);
    }

    public int removeFirst() {
        if (head == null) {
            return 0;
        }
        Node n = head;
        if (head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        size--;
        return size;
    }

    public int removeLast() {
        if (tail == null) {
            return 0;
        }
        Node n = tail;
        if (head.next == null) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
        size--;
        return size;
    }

    public void addFirst(int value) {
        Node n = new Node(value);
        if (size == 0) {
            tail = n;
        } else  {
            head.prev = n;
        }
        n.next = head;
        head = n;
        size++;
    }

    public void addLast(int value) {
        Node n = new Node(value);
        if (size == 0) {
            head = n;
        } else {
           tail.next = n;
           n.prev = head;
        }
        tail = n;
        size++;
    }

public static class Node {
    Node prev;
    Node next;
    int value;

    public Node(int value) {
        this.value = value;
    }


    public Node(Node next, Node prev, int value) {
        this.next = next;
        this.prev = prev;
        this.value = value;
        if (next != null)
            next.prev = this;
        if (prev != null)
            prev.next = this;


    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
}



