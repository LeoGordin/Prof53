package lesson6.list;

public class MyArrayList implements MyList{

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
