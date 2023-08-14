package lesson2.university;

public class Student extends Person {
    private int year;
    private String program;

    public Student(String name, int age, int year, String program) {
        super(name, age); // вызов конструктора супер-класса
        this.year = year;
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public void introduce(){
        super.introduce();
        System.out.println("Student " + getName() + " year " + year);
    }

}
