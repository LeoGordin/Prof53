package lesson33.pool;

import java.util.concurrent.*;

public class PoolTester {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(() -> System.out.println("Hello"));

        Future<String> result = service.submit(() -> "Hello");
        // Future - ссылка на будущий результат
        if(result.isDone())
            System.out.println(result.get());

        System.out.println(result.get(10, TimeUnit.SECONDS));

        service.shutdown(); // пул будет ждать окончания обработки всех заданий
        // service.shutdownNow(); // остановить не дожидаясь окончания обработки

        // дождемся окончания остановки пула потоков или таймаута
        service.awaitTermination(10, TimeUnit.SECONDS);
    }
}
