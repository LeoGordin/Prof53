package lesson8;

import lesson6.list.MyList;

public class MyLinkedList implements MyList {


    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder("[");
        Node n = head;
        while (n != null)
        {
            b.append(n.getValue());
            n = n.getNext();
            if(n != null)
                b.append(", ");
        }
        b.append("]");
        return b.toString();
    }

    private int size = 0;


// добавление элемента в конец списка
    @Override
    public void add(int value)
    {
        size++; // так как мы вставляем новый элемент
        if (head == null)
        {
            head = new Node(value, null);
            return;
        }
        // найти элемент у которого getNext() == null
        Node n = head;
        while (n.getNext() != null)
            n = n.getNext();
        n.setNext(new Node(value, null));
    }

    @Override
    public void add(int index, int value) {
            if(index == 0) {
                // нужно создать новый узел
                head = new Node(value, head);
            }
            else {
                Node prev = getNodeByIndex(index - 1);
                Node next = prev.getNext();
                Node newNode = new Node(value, next);
                prev.setNext(newNode);
            }
        size++;
        }


    @Override
    public void remove(int index) {
        if(index == 0) {
            if (head == null)
                return;
            head = head.getNext();
            size--;
            return;
        }
        Node prev = getNodeByIndex(index - 1);
        if(prev != null)
        {
            Node current = prev.getNext();
            if(current != null)
            {
                prev.setNext(current.getNext());
                size--;
            }

        }
    }




    //структура для хранения данных в LinkedList
        private static class Node {
            private int value; //Значение узла
            private Node next; //Ссылка на следующий узел

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }
    // проверка что элемент с нужным значением содержится в LinkedList
    @Override
    public boolean contains (int value) {
            Node n = head; //текущий узел
            while (n != null)
            {
                // проверить значение
                if (n.getValue() == value)
                    return true;
                    n = n.getNext();
            }
            return false;
    }

    // получение узла по индексу
    private Node getNodeByIndex(int index) {
        Node n = head;
        for (int i=0; i < index; i++) {
            if (n != null)
                n.getNext();

            else
                throw new IndexOutOfBoundsException();
        }
        return n;
    }

    public void set(int index, int value) {
            Node n = getNodeByIndex(index);
            if (n != null)
                n.setValue(value);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        return getNodeByIndex(index).getValue();
    }


    private Node head;

    public int removeFirst()
    {
        int n = get(0);
        remove(0);
        return n;
    }

    public int getFirst()
    {
        return get(0);
    }

    public void addFirst(int value)
    {
        add(0, value);
    }
}
