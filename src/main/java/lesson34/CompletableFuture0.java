package lesson34;

import java.util.concurrent.CompletableFuture;

public class CompletableFuture0 {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        Worker worker = new Worker(future);
        worker.start();

        Thread.sleep(500);
        // future.complete("Here is the result!");
        future.completeExceptionally(new RuntimeException("Something went wrong!"));
    }

    static class Worker extends Thread {

        private CompletableFuture<String> future;

        public Worker(CompletableFuture<String> future)
        {
            super();
            this.future = future;
        }

        @Override
        public void run() {
            try {
                System.out.println("Result is: " + future.get());
            }
            catch (Exception e)
            {
                System.out.println("Exception is: " + e.getCause());
            }
        }
    }
}
