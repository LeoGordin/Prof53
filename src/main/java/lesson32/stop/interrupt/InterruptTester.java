package lesson32.stop.interrupt;

public class InterruptTester {
    public static void main(String[] args) {
        SleepyThread sleepy = new SleepyThread();
        sleepy.start();
        sleepy.interrupt();

        System.out.println("Sleepy interrupted" + sleepy.isInterrupted());

        ActiveThread active = new ActiveThread();
        active.start();
        active.interrupt();
    }
}
