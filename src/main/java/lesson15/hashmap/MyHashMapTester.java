package lesson15.hashmap;

public class MyHashMapTester {
    public static void main(String[] args) {
        MyMap map = new MyHashMap();
        map.put("Canada", "Ottawa");
        map.put("England", "London");
        map.put("France", "Paris");
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.contains("France"));
    }
}
