package lesson34;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCombine {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> combineResult =
                CompletableFuture.supplyAsync(CompletableFutureCombine::hello)
                        .thenCombine(
                                CompletableFuture.supplyAsync(CompletableFutureCombine::world),
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
