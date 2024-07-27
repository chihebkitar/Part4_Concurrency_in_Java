package concurrency.locks;

import java.util.concurrent.locks.ReentrantLock;

public class LockedCounter {

    private int count;
    private ReentrantLock lock = new ReentrantLock();
    // ReentrantLock has lock and unlock methods
    // explicit lock
    // ReentrantLock have trylock method
    // helps with deadlocks problems



    public  void increment(){
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public  int getCount(){
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }


}
