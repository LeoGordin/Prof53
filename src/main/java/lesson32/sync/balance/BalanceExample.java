package lesson32.sync.balance;

public class BalanceExample {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(0);

        BankAccountThread bt1 = new BankAccountThread();
        BankAccountThread bt2 = new BankAccountThread();

        bt1.setBankAccount(b1);
        bt2.setBankAccount(b1);

        bt1.start();
        bt2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        System.out.println(b1.getBalance());

}
static class BankAccount {
    private int balance;
    public synchronized void increaseBalance() {
        balance = balance + 1000;
    }
    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }

    public BankAccount(int balance) {
        this.balance = balance;
    }
}
 static class BankAccountThread  extends Thread {
     BankAccount bankAccount;

     public void setBankAccount(BankAccount bankAccount) {
         this.bankAccount = bankAccount;
     }

     @Override
     public void run() {
         for (int i = 0; i < 10; i++) {
             bankAccount.increaseBalance();
             try {
                 Thread.sleep(10);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
     }
 }
}
