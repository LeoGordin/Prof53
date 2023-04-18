package lesson2.bank;

public class LoanTester {
    public static void main(String[] args) {


        LoanTaker misha = new LoanTaker("Misha", 21000, 73);
        LoanIssuer dina = new LoanIssuer("Dina", true, false);
        System.out.println(dina.toIssue(misha));

        LoanTaker alex = new LoanTaker("Alex", 26000, 30);
        LoanIssuer foma = new LoanIssuer("Foma", false, false);
        System.out.println(foma.toIssue(alex));
    }

}
