package lesson29.homework;


import lesson16.MyGenericBinaryTree;
import lesson16.MyGenericBinaryTree.Vortex;

public class HomeWork {
    public static void main(String[] args) {

        Vortex<String> v = new Vortex<>("one");

        MyGenericBinaryTree<String> tree = new MyGenericBinaryTree<>(v);
        tree.add("two");
        tree.add("five");
        tree.add("ace");
        tree.add("world");
        System.out.println(tree);

        System.out.println(
                myBinarySearch(16, new int[] {1, 3, 7, 12, 31, 44, 57}) // -5
        );


        System.out.println(
                myBinarySearch(44, new int[] {1, 3, 7, 12, 31, 44, 57}) // 5
        );

        System.out.println(
                myGenericBinarySearch("Hello", new String[] {"Ace", "Hello", "Polo", "World"}) // 1
        );

    }



    public static <T extends Comparable<T>> int myGenericBinarySearch(T e, T [] a){
        int minIndex = 0; // номер первого элемента в диапазоне
        int maxIndex = a.length - 1; // номер последнего элемента в диапазоне
        while (minIndex <= maxIndex)
        {
            int midIndex = (maxIndex + minIndex) / 2; // индекс среднего элемента
            if(a[midIndex].compareTo(e) < 0)
            {
                minIndex = midIndex + 1;
            }
            else if(a[midIndex].compareTo(e) > 0)
            {
                maxIndex = midIndex - 1;
            }
            else return midIndex; // то что ищем равно значению под средним индексом
        }
        return - minIndex - 1;
    }


    /*
            1 3 7 12 31 44 57    16? -> -5
            0 1 2 3  4  5  6
     */

    public static int myBinarySearch(int e, int [] a){
        int minIndex = 0; // номер первого элемента в диапазоне
        int maxIndex = a.length - 1; // номер последнего элемента в диапазоне
        while (minIndex <= maxIndex)
        {
            int midIndex = (maxIndex + minIndex) / 2; // индекс среднего элемента
            if(a[midIndex] < e)
            {
                minIndex = midIndex + 1;
            }
            else if(a[midIndex] > e)
            {
                maxIndex = midIndex - 1;
            }
            else return midIndex; // то что ищем равно значению под средним индексом
        }
        return - minIndex - 1;
    }



}
