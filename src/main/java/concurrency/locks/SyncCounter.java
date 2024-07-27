package concurrency.locks;

public class SyncCounter {
        private int count;

        public synchronized void increment(){
            count++;
        }
   /*  similar implicit

   public  void increment(){
            synchronized (this){
        count++;
        }
    }

    */

        public synchronized int getCount(){
            return count;
        }
        // we added kw synchronized
    //when thread enters synchronized methods
    // it acquires lock on obj implicit lock
    // if a thread acquires a lock no other threads
    //can get any of synchronized methods until
    // method completes and releases the lock


    }