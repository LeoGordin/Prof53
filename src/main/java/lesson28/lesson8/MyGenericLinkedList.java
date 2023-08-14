package lesson28.lesson8;

import lesson28.lesson8.homework.MyGenericList;


public class MyGenericLinkedList <T> implements MyGenericList<T> {


    // добавление элемента в конец списка
    @Override
    public void add(T value)
    {
        size++; // так как мы вставляем новый элемент
        if (head == null)
        {
            head = new Node<>(value, null);
            return;
        }
        // найти элемент у которого getNext() == null
        Node<T> n = head;
        while (n.getNext() != null)
            n = n.getNext();
        n.setNext(new Node<>(value, null));
    }



    // получение значения элемента по индексу
    @Override
    public T get(int index) {
        Node<T> n = getNodeByIndex(index);
        return n.getValue();
    }

    @Override
    public void add(int index, T value) {
        if(index == 0) {
            // нужно создать новый узел
            head = new Node<>(value, head);
        }
        else {
            Node<T> prev = getNodeByIndex(index - 1);
            Node<T> next = prev.getNext();
            Node<T> newNode = new Node<>(value, next);
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
        Node<T> prev = getNodeByIndex(index - 1);
        if(prev != null)
        {
            Node<T> current = prev.getNext();
            if(current != null)
            {
                prev.setNext(current.getNext());
                size--;
            }
        }
    }


    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder("[");
        Node<T> n = head;
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







    // получение узла по индексу
    private Node<T> getNodeByIndex(int index)
    {
        Node<T> n = head;
        // нужно index раз сделать getNext()
        for(int i=0; i < index; i++)
        {
            // важно проверить что полученный узел не null
            if(n != null)
                n = n.getNext();
            else
                // если в процессе определится что текущий узел null нужно
                throw new IndexOutOfBoundsException();
        }
        return n;
    }

    // изменение значения элемента по порядковому номеру
    @Override
    public void set(int index, T value)
    {
        Node<T> n = getNodeByIndex(index);
        if(n != null)
            n.setValue(value);
    }






    // проверка что элемент с нужным значением содержится в LinkedList
    @Override
    public boolean contains(T value)
    {
        Node<T> n = head; // текущий узел
        while (n != null)
        {
            // проверяем значение
            if (n.getValue() == value) // если элемент с нужным значением найден
                return true;
            n = n.getNext(); // если же нет, проверяем следующий узел
        }
        return false;
    }



    // структура для хранения данных в LinkedList
    private static class Node<T> {
        private T value; // значение
        private Node<T> next; // ссылка на следующий узел

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> head; // ссылка на первый узел

    private int size = 0; // количество элементов в LinkedList
    @Override
    public int size()
    {
        return size;
    }


    // возвращает значение удаляемого первого элемента
    public T removeFirst()
    {
        T value = getFirst();
        remove(0);
        return value;
    }

    // вернуть самый первый элемент
    public T getFirst()
    {
        return get(0);
    }

    // добавить элемент в начало списка
    public void addFirst(T value)
    {
        add(0, value);
    }

}
