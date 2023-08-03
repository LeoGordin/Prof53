package lesson32.pi;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PiCalculator {
    private static AtomicInteger yes = new AtomicInteger(0); // количество точек внутри четверти круга
    private static AtomicInteger no = new AtomicInteger(0); // количество точек вне четверти круга

    private static Random random = new Random(); // генератор случайных чисел

    public static void init()
    {
        yes = new AtomicInteger(0);
        no = new AtomicInteger(0);
    }

    public static void main(String[] args) {
        runner(10);
        runner(10);
        runner(10);

        // выполните все то-же самое для разного количества потоков
        // 1 2 5 10 20 40 100
        runner(1);
        runner(2);
        runner(5);
        runner(10);
        runner(20);
        runner(40);
        runner(100);

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    static void runner(int numberOfThreads)
    {
        init();
        long before = System.currentTimeMillis();
        // создание пула потоков
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        IntStream.range(0, 1_000_000)
                .forEach(i -> service.submit(new PiRunnable()));
        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long after = System.currentTimeMillis();
        // распечатайте в одну строку
        //     число потоков    время   yes   no     вычисленное pi
        System.out.printf(
                "threads: %d ,t: %d ,y: %d ,x: %d, x+y: %d, pi: %f\n",
                numberOfThreads,
                (after - before),
                yes.get(), no.get(),
                yes.get() + no.get(),
                4.0*yes.get()/(yes.get() + no.get())
        );
    }


    // операция для генерации рандомной точки и определения
    // находится ли она внутри или вне четверти круга
    static class PiRunnable implements Runnable {
        @Override
        public void run() {
            double x = random.nextDouble(); // значение от 0 до 1
            double y = random.nextDouble();
            // вычислите расстояние до центра
            double r = Math.sqrt(x*x + y*y);
            // если оно меньше или равно 1 увеличьте yes
            if(r <= 1)
                yes.incrementAndGet();
            else
                no.incrementAndGet();
        }
    }
}
