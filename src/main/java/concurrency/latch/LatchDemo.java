package concurrency.latch;

import java.util.concurrent.CountDownLatch;

public class LatchDemo {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch endSignal = new CountDownLatch(5);

        for (int i=0;i<5;i++){
            new Thread(new Worker(i,startSignal,endSignal)).start();
        }
        System.out.println("work done before starting workers ...");
        startSignal.countDown();
        System.out.println("doing work while workers are running");
        endSignal.await();
        System.out.println("all workers finished");


    }
}
