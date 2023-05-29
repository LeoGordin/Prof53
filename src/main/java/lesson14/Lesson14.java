package lesson14;

import java.util.*;

public class Lesson14 {
    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>(
                Arrays.asList("Kiwi", "Apple", "Pear", "Banana", "Strawberry", "Apricot", "Peach")
        );
        fruits.sort(Comparator.comparing(s -> s.substring(2, 3)));
        System.out.println(fruits);

        Comparator<String> thirdLetterComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.substring(2, 3).compareTo(o2.substring(2, 3));
            }
        };

        System.out.println(Collections.max(fruits));
        System.out.println(Collections.max(fruits, thirdLetterComparator));

        List<Fruit> f = new ArrayList<>(
                Arrays.asList(
                        new Fruit("Kiwi", 61),
                        new Fruit("Apple", 52),
                        new Fruit("Banana", 89),
                        new Fruit("Cherry", 50)
                )
        );

        // написать компаратор для фруктов на основе калорий
        // инициализировать им TreeSet
        TreeSet<Fruit> fruitSet = new TreeSet<>(
                (o1, o2) -> Integer.compare(o1.getCalories(), o2.getCalories())
        );
        // и добавить все фрукты из списка в fruitSet
        fruitSet.addAll(f);
        System.out.println(fruitSet);

        System.out.println(fruitSet.subSet(
                new Fruit("Fake", 51),
                new Fruit("Fake", 65)
        ));

        System.out.println(fruits);
        System.out.println(
        Collections.binarySearch(fruits, "Lemon", thirdLetterComparator)
        );


    }

}
