package lesson1.japanese;

public class JapaneseEmployee {

    public static void main(String[] args) {
        JapaneseEmployee mitsuo = new JapaneseEmployee("Mitsuo", "Baso", 120_000, 4);
        JapaneseEmployee akira = new JapaneseEmployee("Akira", "Kurosawa", 100_000, 12);

        System.out.println(mitsuo.getFirstName() + " " + mitsuo.calculateSalary());
        System.out.println(akira.getFirstName() + " " + akira.calculateSalary());

        akira.hello();
        mitsuo.hello();
    }

    public void hello() {
        if (years > 10) {
            System.out.println("Good afternoon, " + this.firstName + " " + this.lastName);
        } else {
            System.out.println("Hello " + this.firstName);
        }
    }

    private String firstName;
    private String lastName;
    private double baseSalary;
    private int years;

    public static int delta = 10_000;

    public double calculateSalary() {
        return baseSalary + years * delta;
    }

    public JapaneseEmployee(String firstName, String lastName, double baseSalary, int years) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
        this.years = years;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }


}
