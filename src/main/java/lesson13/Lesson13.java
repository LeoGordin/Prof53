package lesson13;

import java.util.*;

public class Lesson13 {
    public static void main(String[] args) {
        // Comparing objects in Java. Comparator, Comparable. Method sort.
        int a = 1;
        int b = 1;
        System.out.println(a == b);

        String n1 = new String("value");
        String n2 = new String("value");
        System.out.println(n1 == n2);
        System.out.println(n1 == n2);
        System.out.println(n1.equals(n2));

        Cat c1 = new Cat("Barsik", 4);
        Cat c2 = new Cat("Barsik", 4);

        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));

        List<String> groups = new ArrayList<>(
                Arrays.asList("Aerosmith", "Guns and Roses", "Led Zeppelin", "Pearl Jam", "Beatles", "Cranberries")
        );
        System.out.println(groups);
        Collections.sort(groups);
        System.out.println(groups);
        Collections.sort(groups, Comparator.reverseOrder());
        System.out.println(groups);
        }
    Mover penguin = new Mover() {
        @Override
        public void fly() {
            System.out.println("I'm flying");
        }

        @Override
        public void swim() {
            System.out.println("I'm swimming");
        }
    };

    }


class Cat {
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat cat)) return false;
        return age == cat.age && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null)
//            return false;
//        if (!(obj instanceof Cat))
//            return false;
//        if (this == obj)
//            return true;
//        Cat c = (Cat) obj;
//        return age == c.age && name == c.name;
//    }
}
