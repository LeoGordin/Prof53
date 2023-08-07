package lesson34;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Parallel {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Good bye,");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "cruel");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "world!");

        // дождемся выполнения всех этих CF
        CompletableFuture<Void> combined =
                CompletableFuture.allOf(f1, f2, f3);

        combined.get();
        // теперь можем объединить так как выполнение закончилось
        System.out.println(f1.get() + " " + f2.get() + " " + f3.get());
    }
}
