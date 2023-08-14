package lesson2.bank;

public class LoanTester {
    public static void main(String[] args) {
        // если работник ленивый он одобрит кредит если доход заемщика больше 20_000
        // если работник не ленивый но добрый то он одобрит кредит если доход больше 25_000 и
        //      возраст меньше 60
        // если работник не ленивый и злой то одобрит кредит если доход больше 28_000
        //      и клиенту меньше 50 лет

        LoanTaker misha = new LoanTaker("Misha", 21_000, 73);
        LoanIssuer dina = new LoanIssuer("Dina", true, false);
        System.out.println(dina.toIssue(misha));

        LoanIssuer foma = new LoanIssuer("Foma", false, false);
        LoanTaker alex  = new LoanTaker("Alex", 26_000, 30);
        System.out.println(foma.toIssue(alex));

    }
}
