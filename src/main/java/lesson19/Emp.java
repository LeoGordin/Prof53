package lesson19;

public class Emp {
    private String name;
    private int age;
    private String position;

    @Override
    public String toString() {
        return "E{" +
                "n='" + name + '\'' +
                ", a=" + age +
                ", p='" + position + '\'' +
                '}';
    }

    public Emp(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }
}
