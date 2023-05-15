package lesson11;

import java.util.NoSuchElementException;

public class CustomArrayDeque implements CustomDeque {
    private int[] source = new int[INITIAL_CAPACITY]; // массив с элементами дека
    private int size = 0; // сколько элементов в нашем деке
    private int firstElementIndex = 0; // индекс первого элемента дека внутри массива

    private static final int INITIAL_CAPACITY = 4;

    public String toString() {
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int v = source[(firstElementIndex + i) % source.length];
            b.append(v);
            if (i < size - 1) {
                b.append(", ");
            }
        }
        b.append("]");
        return b.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(int value) {
        if (size() == source.length) // если в массиве source больше нет свободных ячеек
            increaseCapacity(); // сделает массив в 2 раза большей длины и копирует туда элементы
        // уменьшить firstElementIndex на 1 c учетом размера source
        firstElementIndex = (firstElementIndex - 1 + source.length) % source.length;
        source[firstElementIndex] = value;
        size++;
    }

    private void increaseCapacity() {
        int[] newSource = new int[source.length * 2];
        int j = 0; // начальный индекс в новом массиве
        for (int i = firstElementIndex; i < source.length; i++) {
            newSource[j++] = source[i];
        }
        for (int i = 0; i < firstElementIndex; i++) {
            newSource[j++] = source[i];
        }
        source = newSource;
    }

    // получение первого элемента дека
    @Override
    public int getFirst() {
        if (size() == 0) throw new IndexOutOfBoundsException();
        return source[firstElementIndex];
    }

    // вернуть значение "первого" элемента и удалить его из дека
    @Override
    public int removeFirst() {
        if (size() == 0)
            throw new IndexOutOfBoundsException();
        // сохранить значение под индексом firstElementIndex
        int value = source[firstElementIndex];
        // сдвинуть "вправо" firstElementIndex с учетом размера source
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size--;
        // вернуть сохраненное значение
        return value;
    }

    @Override
    public void addLast(int value) {
        if (size() == source.length)
            increaseCapacity();
        size++;
        source[size-1] = value;
    }

    @Override
    public int getLast() {
        return source[size-1];
    }

    @Override
    public int removeLast() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        source[size-1] = source[size-2];
        size--;

        // вернуть сохраненное значение
        return source[size-1];
    }
}
