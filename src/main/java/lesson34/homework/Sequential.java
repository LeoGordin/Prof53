package lesson34.homework;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class Sequential {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> sequential =
                CompletableFuture.supplyAsync(Sequential::first)
                        .thenApplyAsync(Sequential::second);

        System.out.println(sequential.get());
    }

    public static Double first()
    {
        // создать две функции -
        //первая:
        //а) спит рандомное время от 0 до 500 мс
        //б) возвращает рандомное число от Double от 0 до 1
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Double d = r.nextDouble();
        System.out.println("first: " + d);
        return d;
    }

    public static Double second(Double f)
    {
        //вторая:
        //а) принимает на вход значение Double
        //б) спит рандомное время от 0 до 500 мс
        //в) возвращает переданное значение, возведенное в квадрат
        //вызвать эти функции через CompletableFuture последовательно и распечатать результат
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return f*f;
    }
}
