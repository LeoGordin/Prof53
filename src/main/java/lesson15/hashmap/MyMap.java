package lesson15.hashmap;

// нужна для реализации нашего собственного контейнера
public interface MyMap {
    int size(); // количество пар
    boolean contains(String key); // есть ли в map пара с таким ключом
    void put(String key, String value); // сохранить пару
    String get(String key); // получение значения по ключу
    String remove(String key); // удаление значения по ключу
}

