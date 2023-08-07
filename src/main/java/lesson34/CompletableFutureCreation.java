package lesson34;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCreation {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(
                () -> {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread: " + Thread.currentThread().getId());
                }
        );

        // лямбда внутри future начнет выполняться после get
        future.get();

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(
                () ->
                {
                    System.out.println("Thread: " + Thread.currentThread().getId());
                    return "Hello";
                }
        ).thenApply(s -> s + " world");
    }
}
