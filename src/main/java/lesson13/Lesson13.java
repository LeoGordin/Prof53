package lesson13;

import lesson2.crossword.C;

import java.util.*;

public class Lesson13 {
    public static void main(String[] args) {
        // Comparing objects in Java. Comparator, Comparable. Method sort.
        int a = 1;
        int b = 1;
        System.out.println(a == b); // true

        String n1 = new String("value");
        String n2 = new String("value");
        System.out.println(n1 == n2); // false
        System.out.println(n1 == n1); // true

        Cat c1 = new Cat("Barsik", 4);
        Cat c2 = new Cat("Barsik", 4);
        System.out.println(c1 == c2); // false
        System.out.println(c1.equals(c2)); // false

        List<String> groups = new ArrayList<>(
                Arrays.asList("Aerosmith", "Guns and Roses", "Led Zeppelin", "Pearl Jam", "Beatles", "Cranberries")
        );
        System.out.println(groups);
        Collections.sort(groups);
        System.out.println(groups);
        Collections.sort(groups, Comparator.reverseOrder());
        System.out.println(groups);



    }
}
class Cat {
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(obj == null)
//            return false;
//        if(this == obj)
//            return true;
//        if(!(obj instanceof Cat))
//            return false;
//        Cat c = (Cat) obj;
//        return age == c.age && name.equals(c.name);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (age != cat.age) return false;
        return name.equals(cat.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}
