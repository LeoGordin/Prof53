package lesson11;

public interface CustomDeque {
    int size(); // сколько всего элементов

    void addFirst(int value); // добавление элемента в начало
    int getFirst(); // посмотреть первый элемент без удаления
    int removeFirst(); // получить первый элемент и удалить его из контейнера

    void addLast(int value); // добавление элемента в конец
    int getLast(); // получить значение последнего элемента без удаления
    int removeLast(); // получить последний элемент и удалить его из контейнера
}
