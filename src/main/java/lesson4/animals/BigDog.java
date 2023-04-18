package lesson4.animals;

public class BigDog extends Dog{

    public BigDog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Wooow");
    }

    @Override
    public void greets(Dog dog) {
        System.out.println("Woooooow");
    }

    public void greets(BigDog bigDog) {
        System.out.println("Wooooooooow");
    }
}
