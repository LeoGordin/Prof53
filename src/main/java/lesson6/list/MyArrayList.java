package lesson6.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList implements MyList, Iterable<Integer> {

    // Написать функцию в MyArrayList, возвращающую итератор,
    // обходящий контейнер по возрастанию значений элементов
    // порядок элементов в контейнере меняться не должен
    public Iterator<Integer> smallToBigIterator()
    {
        return new SmallToBigIterator();
    }

    public class SmallToBigIterator implements Iterator<Integer> {

        // массив с данными для итератора
        private int [] source = new int[size];
        // позиция итератора
        private int position = -1;

        public SmallToBigIterator()
        {
            // скопировать данные из массива data в массив source
            System.arraycopy(data, 0, source, 0, size);
            // отсортировать данные в source
            Arrays.sort(source);
        }

        @Override
        public boolean hasNext() {
            return ++position < size;
        }

        @Override
        public Integer next() {
            if(position < 0 || position >= size)
                throw new NoSuchElementException();
            return source[position];
        }
    }


    // Написать функцию в MyArrayList, возвращающую итератор,
    // обходящий контейнер в обратном порядке
    public Iterator<Integer> backwardIterator() {
        return new Iterator<Integer> () {

            private int position = size;

            @Override
            public boolean hasNext() {
                return --position >= 0 ;
            }

            @Override
            public Integer next() {
                return get(position);
            }
        };
    }


    @Override
    public Iterator<Integer> iterator()
    {
        // если hasNext() == true, то можно вызывать next()
        // реализация итератора через анонимный внутренний класс
        return new Iterator<Integer>() {
            // позиция по-умолчанию
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



    private static final int INITIAL_SIZE = 4; // начальная емкость контейнера
    private int size = 0; // длина контейнера

    private int[] data; // именно тут будут храниться элементы

    public MyArrayList() {
        data = new int[INITIAL_SIZE];
    }

    // количество элементов в списке
    @Override
    public int size() {
        return size;
    }

    // получение элемента по индексу
    @Override
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    // возвращает true если элемент с таким значением уже
    // существует в контейнере
    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value)
                return true;
        }
        return false;
    }

    // заменить значение элемента по index на value
    @Override
    public void set(int index, int value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    // добавление нового элемента в конец контейнера
    @Override
    public void add(int value) {
        if (size == data.length) {
            // увеличить размер массива data
            increaseCapacity();
        }
        data[size] = value;
        size++;
    }

    private void increaseCapacity() {
        int[] newData = new int[size * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
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

    // удалить элемент с порядковым номером index
    // из контейнера
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
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
