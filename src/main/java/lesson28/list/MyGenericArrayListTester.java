package lesson28.list;

public class MyGenericArrayListTester {
    public static void main(String[] args) {
        MyGenericList<String> l = new MyGenericArrayList<>();

        l.add("Hello");
        l.add("World");
        l.add("is");
        l.add("new");
        l.add("capital");

        System.out.println(l);

        System.out.println(l.size());
    }
}
