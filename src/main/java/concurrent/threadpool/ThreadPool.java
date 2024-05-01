package concurrent.threadpool;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.*;

public class ThreadPool {
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    ExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    ExecutorService workStealingPool = Executors.newWorkStealingPool(3);
    ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

    public static void main(String[] args) {
        // corePoolSize – the number of threads to keep in the pool, even if they are idle,
        // unless allowCoreThreadTimeOut is set
        int corePoolSize = 5;

        // maximumPoolSize – the maximum number of threads to allow in the pool
        int maximumPoolSize = 10;

        // keepAliveTime – when the number of threads is greater than the core,
        // this is the maximum time that excess idle threads will wait for new tasks before terminating.
        long keepAliveTime = 10;

        // workQueue – the queue to use for holding tasks before they are executed.
        // This queue will hold only the Runnable tasks submitted by the execute method.
        BlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        BlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>(10);
        BlockingQueue<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<>(10);
        BlockingQueue<Runnable> linkedTransferQueue = new LinkedTransferQueue<>();
        BlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<>(10);
        BlockingQueue<Runnable> synchronousQueue = new SynchronousQueue<>();

        // threadFactory – the factory to use when the executor creates a new thread.
        ThreadFactory threadFactory = new DefaultThreadFactory("My Thread Pool");

        // handler – the handler to use when execution is blocked because the thread bounds and queue capacities are reached.
        RejectedExecutionHandler abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        RejectedExecutionHandler callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        RejectedExecutionHandler discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        RejectedExecutionHandler discardPolicy = new ThreadPoolExecutor.DiscardPolicy();

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                // unit – the time unit for the keepAliveTime argument
                TimeUnit.SECONDS,
                arrayBlockingQueue,
                threadFactory,
                discardPolicy
        );

        System.out.println(threadPool.getPoolSize());

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(
                corePoolSize,
                threadFactory,
                discardPolicy
        );
    }
}
