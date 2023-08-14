package lesson34;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;

public class CompletableFutureCombine {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> combineResult =
                CompletableFuture.supplyAsync(() -> hello())
                        .thenCombine(
                                CompletableFuture.supplyAsync(() -> world()),
                                (s1, s2) -> s1 + " " + s2
                        );

        System.out.println(combineResult.get());
    }

    static String hello() {
        return "Hello";
    }

    static String world() {
        return "World";
    }
}
