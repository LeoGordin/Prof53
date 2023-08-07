package lesson34.exceptions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exceptionally {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "234");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "hello");

        CompletableFuture<String> res =
                cf.thenApply(Integer::parseInt)
                        .thenApply(r -> r * 4)
                        .thenApply(r -> "apply>> " + r)
                        .exceptionally(t -> "Exception: " + t.getCause())
                ;

        System.out.println(res.get());
    }
}
