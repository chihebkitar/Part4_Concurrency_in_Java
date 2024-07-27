package concurrency.callables;

import java.text.MessageFormat;
import java.util.SplittableRandom;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    // class a callable of type string
    // override call method that returns string
    private int id;

    public MyCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return String.format("%s using thread %s",
                this,Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return MessageFormat.format("MyCallable'{'id={0}'}'", id);
    }
}
