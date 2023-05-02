package lesson6.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList implements MyList, Iterable<Integer>{

    public Iterator<Integer> smallToBigIterator() {
        return new smallToBigIterator();
        };
    public class smallToBigIterator implements Iterator<Integer> {

        private int[] source = new int[size];
        private int position = -1;

        public smallToBigIterator() {
            System.arraycopy(data, 0, source,0, size);
            Arrays.sort(source);
        }


        @Override
        public boolean hasNext() {
            return ++position < size;
        }

        @Override
        public Integer next() {
            if (position < 0 || position <= size)
                throw new NoSuchElementException();

            return source[position];
        }
    }

    public Iterator<Integer> backwardIterator() {

        return new  Iterator<Integer>() {

            private int position = size;
            @Override
            public boolean hasNext() {
                return --position >= 0;
            }

            @Override
            public Integer next() {
                return get(position);
            }
        };
    }

    @Override
    public Iterator<Integer> iterator() {
        //реализация итератора через анонимный внутренний класс
        return new Iterator<Integer>() {
            //позиция по умолчанию
            private int position = -1;
            @Override
            public boolean hasNext() {
                return ++position < size;
            }

            @Override
            public Integer next() {
                return get(position);
            }
            @Override
            public void remove() {
                MyArrayList.this.remove(position--);
            }
        };
    }

    private  static final int INITIAL_SIZE = 4; // Начальная емкость контейнера
    private int size = 0; // Длина контейнера

    private int [] data; // тут будут храниться элементы

    public MyArrayList() {
        data = new int[INITIAL_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) { // получение элемента по индексу
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override

    public boolean contains(int value) {
        for (int i = 0 ; i < size; i++)
            {
                if(data[i] == value)
                    return true;
            }
            return false;
        }


    @Override
    public void set(int index, int value) {
        if (index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        data [index] = value;
    }

    @Override
    public void add(int value) { // добавление нового элемента в конец контейнера
        if(size == data.length)
        {
            increaseCapacity();
        }
        data[size] = value;
        size++;
    }

    private void increaseCapacity() {
        int [] newData = new int[size*2];
        for (int i =0; i < size; i++)
        {
            newData [i] = data [i];
        }
        data = newData;
    }
    @Override
    public void add(int index, int value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(size == data.length)
            increaseCapacity();
        for(int i = size - 1; i >= index; i--)
        {
            data[i+1] = data[i];
        }
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index + 1; i < size; i++)
        {
            data [i-1] = data [i];
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("[");
        for(int i = 0; i < size; i++)
        {
            if(i != 0)
                b.append(", ");
            b.append(data[i]);
        }
        b.append("]");
        return b.toString();
    }
}
