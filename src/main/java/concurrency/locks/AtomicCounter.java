package concurrency.locks;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private AtomicInteger count = new AtomicInteger(0);
    // AtomicInteger is a class that wraps int value but makes
    //sure that any update on it happes atomicaally
    // increment and get increment by one
    // get extracts integer value out a i
    // it handles sync automatically
    public  void increment(){
            count.incrementAndGet();
    }

    public  int getCount(){
            return count.get();
    }

}
