package lesson32.stop.interrupt;

public class SleepyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from sleepy thread!");

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            System.out.println("I'm a sleepy thread, my sleep was disturbed");
        }
    }
}
