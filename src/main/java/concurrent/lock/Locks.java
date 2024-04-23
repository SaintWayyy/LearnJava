package concurrent.lock;

import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;

public class Locks {
    public AbstractQueuedSynchronizer aqs;
    public StampedLock stampedLock = new StampedLock();


    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock(); // 获取锁
        try {
            // 执行需要同步的代码块
        } finally {
            reentrantLock.unlock(); // 释放锁
        }


        ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        // 如果一个线程持有了读锁，那么其他线程可以同时持有读锁，但无法获取写锁，直到所有的读锁被释放。
        reentrantReadWriteLock.readLock().lock(); // 获取读锁
        try {
            // 执行读操作
        } finally {
            reentrantReadWriteLock.readLock().unlock(); // 释放读锁
        }

        reentrantReadWriteLock.writeLock().lock(); // 获取写锁
        try {
            // 执行写操作

        } finally {
            reentrantReadWriteLock.writeLock().unlock(); // 释放写锁
        }
    }
}
