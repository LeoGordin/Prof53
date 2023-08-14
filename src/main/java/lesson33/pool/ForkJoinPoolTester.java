package lesson33.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTester {
    public static void main(String[] args) {
        // ForkJoinPool уже есть в ява, нет необходимости конфигурировать
        // не нужно останавливать
        ExecutorService service = ForkJoinPool.commonPool();

        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Time is: " + System.currentTimeMillis());
            }
        });

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
