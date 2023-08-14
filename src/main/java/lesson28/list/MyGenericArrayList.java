package lesson28.list;

public class MyGenericArrayList<T> implements MyGenericList<T> {

    private static final int INITIAL_SIZE = 4; // начальная емкость контейнера
    private int size = 0; // длина контейнера

    private T [] data; // именно тут будут храниться элементы

    public MyGenericArrayList() {
        data = (T[]) new Object[INITIAL_SIZE];
    }

    // количество элементов в списке
    @Override
    public int size() {
        return size;
    }

    // получение элемента по индексу
    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    // возвращает true если элемент с таким значением уже
    // существует в контейнере
    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value))
                return true;
        }
        return false;
    }

    // заменить значение элемента по index на value
    @Override
    public void set(int index, T value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    // добавление нового элемента в конец контейнера
    @Override
    public void add(T value) {
        if (size == data.length) {
            // увеличить размер массива data
            increaseCapacity();
        }
        data[size] = value;
        size++;
    }

    private void increaseCapacity() {
        Object[] newData = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = (T[]) newData;
    }

    @Override
    public void add(int index, T value) {
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
