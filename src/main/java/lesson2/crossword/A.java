package lesson2.crossword;

public class A {
    public void hello()
    {
        System.out.println("Hello from A");
    }

    protected void world()
    {
        System.out.println("World");
    }

    // эту функцию нельзя переопределять в производных классах
    final public void secure()
    {
        System.out.println("Secure A");
    }

}

// создайте класс B расширяющий A
// и класс C расширяющий B
