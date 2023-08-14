package lesson4.animals;

public class Cat extends Animal {
    public Cat(String cat) {
        super(cat);
    }

    @Override
    public void greets() {
        System.out.println("Meow");
    }
}
