package lesson1;

public class DogTester {
    // static - поле или метод относятся к классу целиком
    public static void main(String[] args) {

        // конструктор по-умолчанию
        Dog trezor = new Dog();

/*
        trezor.age = 5;
        trezor.name = "Trezor";
        trezor.breed = "Bulldog";
        trezor.color = "White";
*/

        trezor.setAge(5);
        trezor.setName("Trezor");
        trezor.setBreed("Bulldog");
        // trezor.setColor("White");


        System.out.println("Tresor breed is: " + trezor.getBreed());

        final Dog eleonora = new Dog("Bolonka", "Eleonora", 3, "White");

        System.out.println("Eleonora's age is: " + eleonora.getAge());

        eleonora.setAge(35);
        System.out.println("Eleonora's age is: " + eleonora.getAge());

        trezor.bark();
        eleonora.bark();

        System.out.println("Number of dogs: " + Dog.numberOfDogs);

        Dog.hello();

        eleonora.hello();

        int a = 5;
        int b = 10;
        a = b;

        final int d = 7;
        int e = 12;

        // eleonora = trezor;

        eleonora.setAge(14);

    }
}

// класс - объединение чего-либо по характерным признакам
// класс - шаблон для описания его представителей (экземляр
// экземпляр - конкретный представитель класса
// класс - набор свойств и действий

// модификаторы доступа
// если ничего не указывать, то доступ package private - эти поля видны только в пакете
// public - доступ к полю или методу имеют все классы отовсюду в проекте
// private - доступ имеют только методы этого класса
// protected - доступ имеют только методы класса и его наследников

class Dog {

    // конструктор - нужен чтобы правильно инициализировать свойства экземпляра класса
//    public Dog(String dogBreed, String dogName, int dogAge, String dogColor) {
//        breed = dogBreed;
//        name = dogName;
//        age = dogAge;
//        color = dogColor;
//    }
    // cmd+/
    // ctrl + /


    public Dog(String breed, String name, int age, String color) {
        // this - текущий экземпляр класса
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.color = color;
    }

    // конструктор по-умолчанию
    public Dog() {
        this.color = null;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    // меняйте возраст собаки только если он больше 0 и меньше 30

    public void setAge(int age) {
        if(age > 0 && age < 30) {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

//    public void setColor(String color) {
//        this.color = color;
//    }

    // свойства == переменные класса == поля класса
    private String breed;
    private String name;
    private int age;
    private final String color;

    // методы == функции == действия
    void bark() {
        System.out.println(name + " bark-bark!");
        // hello();
    }

    public static int numberOfDogs = 2;

    public static void hello() {
        System.out.println("Hello");
    }

}
