package lesson32.sync.counters;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterAtomic implements Runnable, Counter {

    private AtomicInteger counter = new AtomicInteger();

    @Override
    public void run() {
        for(int i = 0; i < 1_000_000; i++)
            counter.addAndGet(1);
    }

    @Override
    public int getCounter() {
        return counter.get();
    }
}
