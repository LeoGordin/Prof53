package lesson32.stop.interrupt;

public class StopTester {
    public static void main(String[] args) throws InterruptedException {
        Boolean shouldStop = Boolean.FALSE;

        StoppableThread stoppableThread = new StoppableThread(shouldStop);
        stoppableThread.start();

        Thread.sleep(300);
        stoppableThread.setHasToStop(true);
    }
}
