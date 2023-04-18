package lesson4.animals;

public class AnimalsTester {
    public static void main(String[] args) {
        Cat cat = new Cat("Kiitty");
        cat.greets();

        Dog dog = new Dog("Doge");
        BigDog doggo = new BigDog("Biggo");

        doggo.greets(dog);
        dog.greets(doggo);
    }
}
