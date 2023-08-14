package lesson2.bank;

public class Account {
    private String id;
    private String owner;
    private int balance;

    public Account(String id, String owner, int balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }



    // добавление денег на счет
    // и возвращение полученного баланса
    public int debit(int money){
        if(money < 0)
        {
            System.out.println("отрицательная сумма для дебита");
        }
        else {
            balance += money;
        }
        return balance;
    }

    // удаление денег со счета
    // нельзя удалить больше чем на счете есть
    // при пытытке удалить больше, не нужно менять баланс счета, но нужно
    // печатать об этом сообщение
    // возвращается количество денег оставшихся на балансе
    public int credit(int money)
    {
        if(money > balance)
        {
            System.out.println("сумма больше баланса");
            return 0;
        }
        balance -= money;
        return balance;
    }

    // перевод денег со счета на счет
    // кредитуем свой счет и дебитуем account
    // возвращается баланс счета
    // при попытке снять больше чем есть на счете нужно печатать сообщение
    public int transfer(Account account, int amount)
    {
        // кредитуем наш счет (снимаем с него amount денег)
        // дебитуем счет account на количество реально снятых денег

        // сколько было - сколько стало
        int amountDebited = (balance - credit(amount));
        account.debit(amountDebited);

        return balance;
    }

    public static void main(String[] args) {
        Account a1 = new Account("123", "Misha Semenov", 30);
        Account a2 = new Account("456", "Sergey Petrov", 45);
        a1.transfer(a2, 15);
        System.out.println(a1.balance);
        System.out.println(a2.balance);
    }

}
