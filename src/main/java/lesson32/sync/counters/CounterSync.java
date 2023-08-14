package lesson32.sync.counters;

public class CounterSync implements Counter, Runnable {
    private int counter = 0;

    @Override
    public synchronized void run() {
        for(int i = 0; i < 1_000_000; i++)
            ++counter;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
