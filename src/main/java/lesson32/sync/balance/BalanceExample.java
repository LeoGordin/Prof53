package lesson32.sync.balance;

import lesson2.crossword.B;

import java.util.Objects;

public class BalanceExample {
    public static void main(String[] args) throws InterruptedException {
        // создайте счет с нулевым балансом
        BankAccount account = new BankAccount();
        account.setBalance(0);

        // создайте два потока
        // и передайте в них счет
        BankAccountThread t1 = new BankAccountThread();
        BankAccountThread t2 = new BankAccountThread();
        t1.setBankAccount(account);
        t2.setBankAccount(account);

        // запустите оба потока
        t1.start();
        t2.start();

        // подождите в основном потоке 1 с
        // Thread.sleep(1_000);

        t1.join(); // ожидаем окончания потока
        t2.join(); // ожидаем окончания потока

        // выведите баланс счета на экран
        System.out.println(account.getBalance());
    }
}
class BankAccount {
    private int balance;
    // public synchronized ... означает синхронизацию на классе

    private Object lock = new Object();
    public void increaseBalance() {
        synchronized (lock) { // синхронизируется на экземпляре объекта
            balance = balance + 1000;
        }
    }
    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }
}
class BankAccountThread extends Thread {
    BankAccount bankAccount;
    public void setBankAccount(BankAccount account) { this.bankAccount = account; }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
        {
            bankAccount.increaseBalance();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
