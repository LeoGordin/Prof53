package lesson11;

public interface CustomDeque {
    int size(); //Сколько всего элементов
    void addFirst(int value); //добавление элемента в начало
    int getFirst(); //посмотреть первый элемент без удаления
    int removeFirst(); // получить первый элемент и удалить его из контейнера

    void addLast(int value);
    int getLast(); // посмотреть последний элемент без удаления
    int removeLast(); // получить последний элемент и удалить его из контейнера
}
