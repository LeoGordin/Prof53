package lesson31;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizationTester {

    // массив из одного элемента
    private static int data [] = {0};

    // будет использоваться в качестве объекта для синхронизации
    private static final Object lock = new Object();

    // увеличивает на 1 значение в массиве
    private static /*synchronized*/ void add() // для синхронизации использется SynchronizationTester.class
    {
        // доступ к этому блоку кода
        // одновременно будет только у одного потока
        // для синхронизации доступа используется
        // объект lock

        /*
        synchronized (lock) {
            int j = data[0];
            j++;
            data[0] = j;
        }
         */
        ai.incrementAndGet();
    }

    private static int get()
    {
        // return data[0];
        return ai.get();
    }

    // атомарная переменная - все ее изменения
    // синхронизированы
    private static AtomicInteger ai = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join(); // внутри потока (main) ожидаем окончания выполнения потока t1
        t2.join();
        t2.join();
        t4.join();
        t5.join();

        System.out.println("from main: " + get()); // 5_000_000
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            long id = Thread.currentThread().getId();
            // в цикле миллион раз вызовите функцию add
            for (int i = 0; i < 1_000_000; i++)
                add();
            System.out.println("Thread with id " + id + " result: " + get());
        }
    }
}
