package lesson32;

public class Intro {
    public static void main(String[] args) {
    Thread t1 = new Thread() {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from thread, " + Thread.currentThread().getId());
        }
    };
// создастся ли новый поток так?
    // t1.run(); // Hello from thread, 1

    // запуск нового потока
        t1.start();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Hello from Runnable, thread id is: " + Thread.currentThread().getId());
            }
        };
    }

}
