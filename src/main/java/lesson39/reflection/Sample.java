package lesson39.reflection;

public class Sample {
    private String name;
    public Sample() {
        name = "Java Reflection API";
    }

    public void greeting() {
        System.out.println("Name is: " + name);
    }

    public void jump(int height) {
        System.out.println("Jumping to the height of " + height);
    }

    private void secret()
    {
        System.out.println("It's a secret!");
    }
}
