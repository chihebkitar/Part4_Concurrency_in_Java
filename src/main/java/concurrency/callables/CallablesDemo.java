package concurrency.callables;


import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class CallablesDemo {
    public static void main(String[] args){
        List<MyCallable> callables = Stream.iterate(0, n->n+1)
                .limit(10)
                .map(MyCallable::new)
                .toList();
        // creating a list of callables of string
        ExecutorService service = Executors.newFixedThreadPool(3);
// creating a thread pool of 3 threads using execotor

        try {
            List<Future<String>> futures = service.invokeAll(callables);
            // provide list of callables to invokeAll and get
            // list of futures of string bcz callables are of string
            for (Future<String> future : futures){
                System.out.println(future.get());
                // get will wait until each callable is completed inside its thread
            }

        } catch (InterruptedException | ExecutionException e) {
            // multicatch since java7
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
            // in case of error
        }

    }
}
