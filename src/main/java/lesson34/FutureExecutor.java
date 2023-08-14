package lesson34;

import java.util.concurrent.*;

public class FutureExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> res = service.submit(new Work());
        System.out.println(res.get());
        service.shutdown();
    }

    static class Work implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(3_000);
            return "Time is: " + System.currentTimeMillis();
        }
    }
}

