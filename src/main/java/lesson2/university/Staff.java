package lesson2.university;

public class Staff extends Person {
    private int salary;
    private String faculty;

    public Staff(String name, int age, int salary, String faculty) {
        super(name, age);
        this.salary = salary;
        this.faculty = faculty;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public void introduce() {
        System.out.println("Staff " + getName() + " salary " + salary);
    }

//    @Override
//    public void introduce(String name)
//    {
//
//    }
}
