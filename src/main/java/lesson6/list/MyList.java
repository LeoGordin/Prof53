package lesson6.list;

// интерфейс это набор методов, которые должны реализовывать наследники

// Класс может реализовывать несколько интерфейсов, но наследовать только один класс

public interface MyList {
    int size(); // возвращать размер списка
    int get(int index); // получение элемента по списку
    boolean contains(int value); // содержится ли элемент в списке
    void set(int index, int value); // изменение элемента
    void add(int value); // добавление элемента в конец
    void add(int index, int value); // добавление элемента
    void remove(int index); // удаление элемента по индексу
}
