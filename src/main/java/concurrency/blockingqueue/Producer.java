package concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private int id;

    private BlockingQueue<Message> queue;
    // bq is holding messages
    // BlockingQueue is java datastructure to coordinate p and c
//A Queue that additionally supports operations that wait for the queue to become non-empty when retrieving an element, and wait for space to become available in the queue when storing an element.
    public Producer(int id, BlockingQueue<Message> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            Message msg = new Message(i);
            try {
                System.out.printf("Producer %d produced %d%n",id,msg.getId());
                queue.put(msg);
                Thread.sleep((long) (Math.random()*100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // im going to produce messages 100 times
            // put them on queue and sleep for radom time

        }
        try {
            queue.put(new Message(-1));
            // indication of termination
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
