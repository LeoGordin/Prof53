package lesson32.sync.counters;

public class CounterClassic extends Thread implements Counter {
    private int counter = 0;

    @Override
    public void run() {
        for(int i = 0; i < 1_000_000; i++)
            ++counter;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
