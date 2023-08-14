package lesson2.bank;

public class LoanIssuer {
    // кредитный офицер
    private String name;
    private boolean isLazy; // ленивый
    private boolean isKind; // добрый

    public LoanIssuer(String name, boolean isLazy, boolean isKind) {
        this.name = name;
        this.isLazy = isLazy;
        this.isKind = isKind;
    }

    public boolean toIssue(LoanTaker taker)
    {
        // если работник ленивый он одобрит кредит если доход заемщика больше 20_000
        if (isLazy && taker.getYearlyIncome() > 20_000)
            return true;
        // если работник не ленивый но добрый то он одобрит кредит если доход больше 25_000 и
        //      возраст меньше 60
        if(!isLazy && isKind && taker.getYearlyIncome() > 25_000 && taker.getAge() < 60)
            return true;
        // если работник не ленивый и злой то одобрит кредит если доход больше 28_000
        //      и клиенту меньше 50 лет
        if(!isLazy && !isKind && taker.getYearlyIncome() > 28_000 && taker.getAge() < 50)
            return true;

        return false;
    }

}
