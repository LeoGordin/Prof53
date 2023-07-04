package lesson28.list;
    public interface MyGenericList<T> {
        int size(); // возвращать размер списка
        T get(int index); // получение элемента по списку
        boolean contains(T value); // содержится ли элемент в списке
        void set(int index, T value); // изменение элемента
        void add(T value); // добавление элемента в конец
        void add(int index, T value); // добавление элемента
        void remove(int index); // удаление элемента по индексу
    }
