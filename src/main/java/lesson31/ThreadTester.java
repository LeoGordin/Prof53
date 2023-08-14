package lesson31;
/*
Многопоточность multithreading
Процесс - выполняющаяся программа
Процессор - микросхема на которой операционная система компьютера
    выполняет программы
Варианты увеличения производительности
    выше тактовая частота
    больше центральных процессоров
    больше ядер на централльном процессоре
Ядро проуессора (core) -  вычислительный модуль который может параллельно выполнять
    метод из процесса
Поток выполнения (thread), "нить" - метод процесса, который может выполняться параллельно

RxJava3 - библиотека с расширенными возможностями работы с многопоточностью
Reactor - библиотека с расширенными возможностями работы с многопоточностью в Spring
 */

// Поток?
// потоки ввода-вывода iostream
// потоки из Streams Arrays.asStream(..).filter(....).map(...)
// потоки выполнения - threads
public class ThreadTester {
    public static void main(String[] args) {
        // у кажого потока выполнения в ява есть свой идентификтор
        System.out.println(
                "Main thread id: " + Thread.currentThread().getId()
        );

        // поток выполнения с "пустой" работой
        // Thread - конкретный класс в яве
        Thread t1 = new Thread();

        Thread t2 = new Thread() {
            // в методе run определяется, что будет выполнять поток
            @Override
            public void run() {
                System.out.println("Thread id: " + Thread.currentThread().getId());
            }
        };

        // запускаем новый поток на исполнение
        t2.start();
        // t2.start(); // IllegalThreadStateException

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

        // можно поток сделать демоном - при этом основной поток не будет дожидаться
        // его завершения
        Thread workingThread = new Thread(() -> {
            try {
                work();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        // по-умолчанию процесс ожидает завершения всех запущенных в нем потоков
        // workingThread.start();
        // "демонизация" потока освобождает основной поток от необходимости
        // ожидать окончания выполнения порожденного потока
        workingThread.setDaemon(true);
        // повышение приоритета позволяет больше времени выделять на исполнение потока
        workingThread.setPriority(Thread.MAX_PRIORITY);
        // демонизацию и приоритезацию нужно выполнить до старта потока
        workingThread.start();

        // одновременно могут выполняться ровно столько потоков
        // сколько ядер во всех процессорах компьютера
        Runtime runtime = Runtime.getRuntime();
        System.out.println("number of cores: " + runtime.availableProcessors());
    }

    public static void work() throws InterruptedException {
        long id = Thread.currentThread().getId();
        for(int i = 0; i < 10; i++)
        {
            System.out.println("Work thread with id: " + id + " time is: " + System.currentTimeMillis());
            Thread.sleep(500); // тормозит текущий поток на 500 мс
        }
    }
}
