package lesson31;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadPoolTester {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    // пул потоков из 2 потоков
    ExecutorService service = Executors.newFixedThreadPool(2);
    Runnable r = new Work();
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
    // остановка пула потоков когда все задачи выполнены

    Callable<String> myCallable = new myCallable();

    // Future это результат который будет доступен
    // в будущем
    Future<String> result = service.submit(myCallable);

//        if(result.isDone())
//    {
//        // сделать что-то если результат уже есть
//    }

        System.out.println("result: " + result.get()); // дождаться результата

        service.shutdown();
}

//Примитив для запуска в пуле потоков, который может возвратить значение
    private static class myCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(300);
            return " " + System.currentTimeMillis();
        }
    }

    private static class Work implements Runnable {
        @Override
        public void run() {
            Random r = new Random();
            try {
                Thread.sleep(r.nextInt(500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread id: " + Thread.currentThread().getId() );
        }
    }
}
