package lesson13.homework;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(id, o.getId());
    }

    public static Comparator<Employee> ageComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    };

    public static Comparator<Employee> salaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o1.getSalary(), o2.getSalary());
        }
    };

    public static Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName);


    public static void compositeSort(List<Employee> e, List<Comparator<Employee>> c) {
        if(c != null && c.size() > 0) {
            Comparator<Employee> complexComparator = c.get(0);
            for (int i = 1; i< c.size(); i++) {
                complexComparator = complexComparator.thenComparing(c.get(i));
            }
            Collections.sort(e, complexComparator);
        }
    }
}

