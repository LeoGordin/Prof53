package lesson32.stop.interrupt;

public class StoppableThread extends Thread {
    private Boolean hasToStop = false;

    public StoppableThread(Boolean hasToStop)
    {
        this.hasToStop = hasToStop;
    }

    public void setHasToStop(Boolean hasToStop) {
        this.hasToStop = hasToStop;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Stoppable index is: " + i);
            if(hasToStop)
            {
                System.out.println("I has to stop!");
                return;
            }
        }
    }
}
