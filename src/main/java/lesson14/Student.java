package lesson14;

public class Student {
    private String name;
    private int year;
    private String group;

    public Student(String name, int year, String group) {
        this.name = name;
        this.year = year;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGroup() {
        return group;
    }
}
