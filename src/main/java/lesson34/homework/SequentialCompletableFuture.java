package lesson34.homework;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SequentialCompletableFuture {
    private static Random random = new Random();

    public static double randomSleepAndReturnRandomDouble() {
        try {
            int sleepTime = random.nextInt(500);
            Thread.sleep(sleepTime);
            return random.nextDouble();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static double squareDoubleWithSleep(Double value) {
        try {
            int sleepTime = random.nextInt(500);
            Thread.sleep(sleepTime);
            return value * value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        CompletableFuture<Double> future1 = CompletableFuture.supplyAsync(SequentialCompletableFuture::randomSleepAndReturnRandomDouble);
        CompletableFuture<Double> future2 = future1.thenApply(SequentialCompletableFuture::squareDoubleWithSleep);

        try {
            double result = future2.get();
            System.out.println("Результат: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

