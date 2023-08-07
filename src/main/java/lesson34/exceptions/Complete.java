package lesson34.exceptions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;

public class Complete {
    public static void main(String[] args) {
        // CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "234");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "hello");

        CompletableFuture<String> res =
                cf.thenApply(Integer::parseInt)
                        .thenApply(r -> r * 4)
                        .thenApply(r -> "apply>> " + r)
                        .whenComplete((s, t) -> {
                            if (t != null)
                                System.out.println(t.getCause());
                            else
                                System.out.println("result is: " + s);
                        });

        try {
            res.get();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getCause());
        }
    }
}
