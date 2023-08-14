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
        map.put("Ireland", "Dublin");
        map.put("Belgium", "Brussels");
        System.out.println(map);
        System.out.println(map.size());

        map.remove("Poland");
        System.out.println(map);
        System.out.println(map.size());
        map.remove("England");
        System.out.println(map);
        System.out.println(map.size());
    }
}
