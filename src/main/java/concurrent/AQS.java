package concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

public class AQS {
    public AbstractQueuedSynchronizer aqs;
    public CountDownLatch countDownLatch = new CountDownLatch(2);
    public Semaphore semaphore = new Semaphore(2);
    public CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    @Test
    public void countDownLatch() throws InterruptedException {
        // 其他线程
        countDownLatch.countDown();

        // 等待线程
        countDownLatch.await();
    }

    @Test
    public void semaphore() throws InterruptedException {
        // 获取许可
        semaphore.acquire();

        // 释放许可
        semaphore.release();
    }

    @Test
    public void cyclicBarrier() throws BrokenBarrierException, InterruptedException {
        // 等待其他线程
        cyclicBarrier.await();
    }
}

