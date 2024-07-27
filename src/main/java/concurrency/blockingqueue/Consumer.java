package concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private int id;

    private BlockingQueue<Message> queue;
    // ref to bq

    public Consumer(int id, BlockingQueue<Message> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {

            Message msg ;
            try {
                while ((msg = queue.take()).getId()!= -1) {
                    // take will block util there is a msg to retrieve
                    System.out.printf("Consumer %d consumed %d%n", id, msg.getId());
                    Thread.sleep((int) (Math.random() * 100));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }



}
