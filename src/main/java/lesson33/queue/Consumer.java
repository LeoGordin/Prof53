package lesson33.queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private final BlockingQueue<Message> queue;
    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10_000);
            // в цикле while получает сообщения до тех пор пока не встретится сообщение exit
            // нужно просто выйти из while
            Message message;
            while (!(message = queue.take()).getMsg().equals("exit")) {
                // Сообщать в консоли о msg каждого принятого сообщения
                System.out.println("Consumed: " + message.getMsg());
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}