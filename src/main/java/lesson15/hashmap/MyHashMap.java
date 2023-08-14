package lesson15.hashmap;

public class MyHashMap implements MyMap {

    private static class Pair { // пара из ключа и значения
        String key;
        String value;
        Pair next; // ссылка на следующую пару

        public Pair(String key, String value, Pair next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + key + ":" + value + "}";
        }
    }

    // начальный размер массива
    private static final int INITIAL_CAPACITY = 4;

    // массив с парами
    private Pair[] source = new Pair[INITIAL_CAPACITY];

    // количество хранящихся пар
    private int size = 0;

    // коэффициент загруженности
    private static final double LOAD_FACTOR = 0.75;
    // если size > LOAD_FACTOR * source.length
    // то Map нужно перебалансировать
    // O(1) поиск в HashMap
    // балансировка - создание массива в 2 раза
    // большей длины и копирование туда пар из старого



    @Override
    public int size() {
        return size;
    }

    // нахождение нужного ведра по ключу
    private int findBucket(String key)
    {
        return Math.abs(key.hashCode()) % source.length;
    }

    // нахождение пары по ключу
    private Pair findPair(String key)
    {
        int bucket = findBucket(key);
        Pair current = source[bucket];
        while (current != null )
        {
            if(current.key.equals(key))
                return current;
            current = current.next;
        }
        return null;
    }


    // есть ли в Map пара с таким ключом
    @Override
    public boolean contains(String key) {
        return findPair(key) != null;
    }

    // добавление новой пары или изменение значения
    // у уже имеющейся
    @Override
    public void put(String key, String value) {
        if (size() > LOAD_FACTOR * source.length)
            resize();
        Pair pair = findPair(key);
        if(pair != null)
        {
            // если пара с таким ключом уже есть
            // просто поменяем у нее значение
            pair.value = value;
        }
        else {
            // создать пару
            int bucket = findBucket(key);
            // и добавить ее в массив с next=
            source[bucket] = new Pair(
                    key,
                    value,
                    source[bucket] // то что было раньше
            );
            // имеющуюся в массиве пару
            // увеличить размер
            size++;
        }
    }

    // перебалансировка массива
    private void resize()
    {
        // создание нового массива в 2 раза
        // большей длины и копирование туда всех элементов
        Pair [] newSource = new Pair[source.length * 2];
        for(Pair p : source)
        {
            Pair current = p;
            while (current != null)
            {
                Pair next = current.next;
                // ведро в новом массиве
                int newBucket =
                        Math.abs(current.key.hashCode()) %
                                newSource.length;
                current.next = newSource[newBucket];
                newSource[newBucket] = current;
                current = next;
            }
        }
        source = newSource;
    }

    // возвратить значение пары по ключу
    @Override
    public String get(String key) {
        Pair pair = findPair(key);
        if(pair != null)
            return pair.value;
        return null;
    }

    @Override
    public String remove(String key) {
        int bucket = findBucket(key);
        Pair current = source[bucket];
        if(current == null) // в бакете нет элемента
            return null;
        if(current.key.equals(key)) { // нужный элемент находится непосредственное в бакете
            source[bucket] = current.next;
            size--;
            return current.value;
        }
        while (current.next != null) // нужный элемент находится внутри цепочки
        {
            if(current.next.key.equals(key))
            {
                Pair toDelete = current.next;
                current.next = toDelete.next;
                size--;
                return toDelete.value;
            }
        }
        return null; // если элемент с таким ключом отсутствует
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        int s = size() - 1;
        for(Pair p : source)
        {
            Pair current = p;
            while (current != null)
            {
                builder.append(current);
                if(--s >= 0)
                    builder.append(", ");
                current = current.next;
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
