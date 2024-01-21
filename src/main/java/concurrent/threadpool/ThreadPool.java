package concurrent.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        ExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        ExecutorService workStealingPool = Executors.newWorkStealingPool(3);

        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);


    }
}
