package lesson34.homework;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// создать две функции, которые:
//а) спят рандомное время от 0 до 500 мс
//б) возвращают рандомное число от Double от 0 до 1
//вызвать эти функции через CompletableFuture параллельно и распечатать сумму их результатов
public class Parallel {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> f = CompletableFuture.supplyAsync(() -> first());
        CompletableFuture<Double> s = CompletableFuture.supplyAsync(Parallel::second);

        CompletableFuture<Void> p = CompletableFuture.allOf(f, s);

        p.get(); // запускает
        System.out.printf("f:%f, s:%f, f+s:%f\n", f.get(), s.get(), f.get() + s.get());
    }

    public static Double first()
    {
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return r.nextDouble();
    }
    public static Double second()
    {
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return r.nextDouble();
    }
}
