package lesson2.bank;

public class LoanTaker {

    private String name;
    private double yearlyIncome;
    private int age;

    public LoanTaker (String name, double yearlyIncome, int age) {
        this.name = name;
        this.yearlyIncome = yearlyIncome;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(double yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
