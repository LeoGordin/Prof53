package lesson6.list;

public class MyArrayList implements MyList{

    private  static final int INITIAL_SIZE = 8; // Начальная емкость контейнера
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
}
