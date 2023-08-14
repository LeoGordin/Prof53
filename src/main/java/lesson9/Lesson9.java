package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson9 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        // ArrayList - реализация интерфейса List основанная на массиве


        List<String> dogs = Arrays.asList("Dog", "Chau-Chau", "Terrier");
        // Arrays.asList() это функция создающая List заданной длины

        // dogs.add("Sheperd dog");
        dogs.set(0, "Akita Inu");
        System.out.println(dogs);

        List<String> countries = new ArrayList<>(
                Arrays.asList("Norway")
        );
    }
}
