package lesson29;

public class Homework {
    public static void main(String[] args) {
        System.out.println(
                myGenericBinarySearch("Hello", new String[]{"Ace", "Hello", "Polo", "World"})
        );
    }

    public static <T extends Comparable<T>> int myGenericBinarySearch(T e, T[] a) {
        int minIndex = 0; // номер первого элемента в диапазоне
        int maxIndex = a.length - 1; // номер последнего элемента в диапазоне
        while (minIndex <= maxIndex) {
            int midIndex = (maxIndex + minIndex) / 2; // индекс среднего элемента
            if (a[midIndex].compareTo(e) < 0) {
                minIndex = midIndex + 1;
            } else if (a[midIndex].compareTo(e) > 0) {
                maxIndex = midIndex - 1;
            } else return midIndex; // то что ищем равно значению под средним индексом
        }
        return -minIndex - 1;
    }
}