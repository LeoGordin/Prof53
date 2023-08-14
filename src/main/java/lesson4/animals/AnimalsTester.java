package lesson4.animals;

public class AnimalsTester {
    public static void main(String[] args) {
        // Animal animal = new Animal("aaa");
        Cat cat = new Cat("Kitty");
        cat.greets();

        Dog dog = new Dog("dog");
        BigDog bigDog = new BigDog("big dog");

        dog.greets(dog);
        dog.greets(bigDog);

        bigDog.greets(dog);
        bigDog.greets(bigDog);
    }
}
