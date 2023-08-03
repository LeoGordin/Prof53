package lesson32.stop.interrupt;

public class ActiveThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello from active thread!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " is interrupted: " + isInterrupted());
        }

    }
}
