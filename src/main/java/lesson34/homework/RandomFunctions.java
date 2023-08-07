package lesson34.homework;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RandomFunctions {
    private static Random random = new Random();

    public static double randomSleep() {
        try {
            int sleepTime = random.nextInt(500);
            Thread.sleep(sleepTime);
            return sleepTime;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static double randomDouble() {
        return random.nextDouble();
    }

    public static void main(String[] args) {
        CompletableFuture<Double> future1 = CompletableFuture.supplyAsync(RandomFunctions::randomSleep);
        CompletableFuture<Double> future2 = CompletableFuture.supplyAsync(RandomFunctions::randomDouble);

        CompletableFuture<Double> combinedFuture = future1.thenCombine(future2, Double::sum);

        try {
            double sum = combinedFuture.get();
            System.out.println("Сумма результатов: " + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
