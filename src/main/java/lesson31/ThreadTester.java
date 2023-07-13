package lesson31;

// Поток?
// потоки ввода-вывода iostream
// потоки из Streams Arrays.asStream(..).filter(....).map(...)
// потоки выполнения - threads
public class ThreadTester {
    public static void main(String[] args) throws InterruptedException {
        // у кажого потока выполнения в ява есть свой идентификтор
        System.out.println(
                "Main thread id: " + Thread.currentThread().getId()
        );
        // Поток выполнения с пустой работой
        Thread t1 = new Thread();

        Thread t2 = new Thread() {
            // в методе run() определяется что будет выполнять поток

            @Override
            public void run() {
                System.out.println("Thread id : " + Thread.currentThread().getId());
            }
        };

        //Запускаем новый поток на исполнение
        t2.start();

        // Runnable - некоторая работа которую возможно потребуется выполнить несколько раз
        // Runnable это интерфейс
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread id: " + Thread.currentThread().getId());
            }
        };
        // самый простой способ запуска Runnable
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();

        // можно поток сделать демоном - при этом основной поток не будет дожидаться
        // его завершения
        // можно поток сделать демоном - при этом основной поток не будет дожидаться
        // его завершения
        Thread workingThread = new Thread(() -> {
            try {
                work();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        // "демонизация" потока освобождает основной поток от необходимости
        // ожидать окончания выполнения порожденного потока

        workingThread.setDaemon(true);
        workingThread.setPriority(Thread.MAX_PRIORITY);
        workingThread.start();

        // одновременно могут выполняться ровно столько потоков
        // сколько ядер во всех процессорах компьютера
        Runtime runtime = Runtime.getRuntime();
        System.out.println("number of cores: " + runtime.availableProcessors());

    }

    public static void work() throws InterruptedException {
        long id = Thread.currentThread().getId();
        for (int i = 0; i < 10; i++) {
            System.out.println("Work thread with id: " + id + " time is: " + System.currentTimeMillis());
            Thread.sleep(500); // тормозит текущий поток на 500мс
        }
    }
}
