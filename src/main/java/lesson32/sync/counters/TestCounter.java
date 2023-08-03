package lesson32.sync.counters;

public class TestCounter {

    public static void main(String[] args) throws InterruptedException {
//        CounterClassic cc = new CounterClassic();
//
//        CounterSync cs = new CounterSync();
        CounterAtomic cs = new CounterAtomic();

        Thread t3 = new Thread(cs, "Second");
        Thread t4 = new Thread(cs, "Second");

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println(cs.getCounter());


    }
}
