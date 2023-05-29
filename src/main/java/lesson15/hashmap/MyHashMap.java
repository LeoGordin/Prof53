package lesson15.hashmap;

public class MyHashMap implements MyMap {
    // начальный размер массива
    private static final int INITIAL_CAPACITY = 4;

    // массив с парами
    private Pair[] source = new Pair[INITIAL_CAPACITY];

    // количество хранящихся пар
    private int size = 0;

    // коэффициент загруженности
    private static final double LOAD_FACTOR = 0.75;
    @Override
    public int size() {
        return size;
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

    private void resize() {
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
                        current.key.hashCode() %
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
        Pair previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                String value = current.value;
                if (previous == null) {
                    source[bucket] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return value;
            }
            previous = current;
            current = current.next;
        }
        return null;

    }
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
            return "Pair{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }
    }


}