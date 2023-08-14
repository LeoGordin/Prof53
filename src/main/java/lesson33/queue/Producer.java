package lesson33.queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        long before = System.currentTimeMillis();
        for(int i = 0; i < 30; i++)
        {
            Message message = new Message("index : " + i);
            try {
                Thread.sleep(i * 20);
                queue.put(message);
                System.out.println("Produced: " + message.getMsg() + " time is: " + (System.currentTimeMillis() - before)/1000f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            queue.put(new Message("exit"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
