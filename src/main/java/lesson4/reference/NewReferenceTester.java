package lesson4.reference;

public class NewReferenceTester {
    public static void main(String[] args) {
        int [] a = new int[1];
        a [0] = 10;
        change(a);
        System.out.println(a[0]);

    }

    public static void change (int array []){

        array = new int[10];
        array[0] = 1000;
    }
}
