package lesson34;

import java.util.concurrent.CompletableFuture;

public class CompletableFuture0 {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();
        Worker worker = new Worker(future);
        worker.start();
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

        }
    }
}
