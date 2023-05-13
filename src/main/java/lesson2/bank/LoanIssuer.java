package lesson2.bank;

public class LoanIssuer {

   private String name;
   boolean isLazy;
   boolean isKind;

    public LoanIssuer(String name, boolean isLazy, boolean isKind) {
        this.name = name;
        this.isLazy = isLazy;
        this.isKind = isKind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }

    public boolean isKind() {
        return isKind;
    }

    public void setKind(boolean kind) {
        isKind = kind;
    }

    public boolean toIssue(LoanTaker taker) {

        // если работник ленивый он одобрит кредит если доход заемщика больще 20_000
        // если работник не ленивый но добрый то он одобрит кредит если доход больше 25_000 и
        //      возраст меньше 60
        // если работник не ленивый и злой то одобрит кредит если доход больше 28_000
        //      и клиенту меньше 50 лет

        if (isLazy && taker.getYearlyIncome() >= 20000) {
            return true;
        }
        if (!isLazy && isKind && taker.getYearlyIncome() > 25000 && taker.getAge() < 60) {
            return true;

        }
        return !isLazy && !isKind && taker.getYearlyIncome() > 28000 && taker.getAge() < 50;


    }
}
