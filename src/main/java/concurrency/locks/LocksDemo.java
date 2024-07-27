package concurrency.locks;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LocksDemo {
    // our goal is to acquire a lock on a object
    // so we synchronize threads

    private Counter counter = new Counter();
    private SyncCounter scounter = new SyncCounter();
    private LockedCounter lcounter = new LockedCounter();
    private AtomicCounter acounter = new AtomicCounter();


    // make a ctp a use 1000 lambda exp
    // for each one im going to submit increment of counter
    // submit takes a runnable or collable
    // returns future of ?(any type)
    // returns null if runnable
    // returns value if collable
    // increment is executed by multiple threads as same time
    // they can skip numbers bcz interference
    private void demoCounter(){
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0,1000)
                .forEach(i -> service.submit(counter::increment));
        service.shutdown();
        System.out.println("counter count= "+ counter.getCount());
    }
    private void demoSyncCounter(){
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0,1000)
                .forEach(i -> service.submit(scounter::increment));
        service.shutdown();
        System.out.println("synccounter count= "+ scounter.getCount());
    }
    private void demoLockedCounter(){
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0,1000)
                .forEach(i -> service.submit(lcounter::increment));
        service.shutdown();
        System.out.println("LockedCounter count= "+ lcounter.getCount());
    }
    private void demoAtomicCounter(){
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0,1000)
                .forEach(i -> service.submit(acounter::increment));
        service.shutdown();
        System.out.println("AtomicCounter count= "+ acounter.getCount());
    }

    public static void main(String[] args){
        LocksDemo demo = new LocksDemo();
        demo.demoCounter();
        demo.demoSyncCounter();
        demo.demoLockedCounter();
        demo.demoAtomicCounter();
    }
}
