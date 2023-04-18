package lesson1;

public class DogTester {
    public static void main(String[] args) {
        // static - поле или метод относится к классу целиком
        Dog trezor = new Dog();
        trezor.setAge(5);
        trezor.setName("Trezor");
        trezor.setBreed("Bulldog");
        trezor.setColor("White");

        System.out.println("Trezor breed is " + trezor.getBreed());

        Dog eleonora = new Dog("Bolonka", "Eleonora", 3, "White");

        System.out.println("Eleonora's age is " + eleonora.getAge());

        eleonora.bark();
        trezor.bark();

        System.out.println("Number of Dogs: " + Dog.numberOfDogs);

        Dog.hello();

    }
}
//класс - объединение чего-либо по характерным признакам
//класс - шаблон для описания его представителей
//экземпляр - конкретный представитель класса
//класс - набор свойств и действий

//свойства == переменные класса == поля класса
class Dog {
    //конструктор - нужен чтобы проинициализировать свойства экземпляра класса

    public Dog() {

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
    // меняйте возраст собаки только если от больше 0 и меньше 30
    public void setAge(int age) {
        if (age >=0 && age <= 30){
        this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Dog(String dogBreed, String dogName, int dogAge, String dogColor) {
      breed = dogBreed;
      name = dogName;
      age = dogAge;
      color = dogColor;
    }
    // модификаторы доступа
// если ничего не указывать, то доступ package private - эти поля видны только в пакете
// public - доступ к полю или методу имеют все классы отовсюду в проекте
// private - доступ имеют только методы этого класса
// protected - доступ имеют только методы класса и его наследников
    private String breed;
    private String name;
    private int age;
    private String color;

    //методы == функции == действия
    void bark() {
        System.out.println(name + " bark-bark!"); //гавкнуть
    }

    public static int numberOfDogs = 2;

    public static void hello() {
        System.out.println("Hello!");
    }

}

