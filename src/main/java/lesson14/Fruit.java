package lesson14;

public class Fruit {
    String name;
    int calories;

    public Fruit(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
