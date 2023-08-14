package lesson32.stop.interrupt;

public class InterruptTester {
    public static void main(String[] args) {
        SleepyThread sleepy = new SleepyThread();
        sleepy.start(); // запускаем
        sleepy.interrupt(); // прерываем
        System.out.println("Sleepy interrupted: " + sleepy.isInterrupted());

        // напишите код для создания, запуска и прерывания активного потока
        ActiveThread active = new ActiveThread();
        active.start();
        active.interrupt();
        System.out.println("Active interrupted: " + active.isInterrupted());

    }
}
