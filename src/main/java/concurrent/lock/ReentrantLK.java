package concurrent.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLK<T> {
    // 一个线程在持有锁的情况下，再次获取同一把锁，而不会被阻塞
    public Lock reentrantLock = new ReentrantLock(false);
    public Condition condition = reentrantLock.newCondition();

    private Queue<T> buffer = new LinkedList<>();
    private int capacity = 5;

    public ReentrantLK(int capacity){
        this.capacity = capacity;
    }

    public void produce(T data) throws InterruptedException {
        try {
            reentrantLock.lock();
            while(buffer.size() == capacity){
                condition.await();
            }

            buffer.offer(data);
        }finally {
            condition.signalAll();
            reentrantLock.unlock();
        }
    }

    public T consume() throws InterruptedException {
        try {
            reentrantLock.lock();
            while(buffer.isEmpty()){
                condition.await();
            }

            return buffer.poll();
        }finally {
            condition.signalAll();
            reentrantLock.unlock();
        }
    }

    public T peek(){
        try {
            reentrantLock.lock();
            return buffer.peek();
        }finally {
            reentrantLock.unlock();
        }
    }
}
