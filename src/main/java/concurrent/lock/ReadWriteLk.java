package concurrent.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.*;

public class ReadWriteLk<T> {
    public ReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);
    public Lock readLock = readWriteLock.readLock();
    public Lock writeLock = readWriteLock.writeLock();
    public Condition writeCondition = writeLock.newCondition();
    public Condition readCondition = readLock.newCondition();

    private Queue<T> buffer = new LinkedList<>();
    private int capacity = 5;

    public ReadWriteLk(int capacity){
        this.capacity = capacity;
    }

    public void produce(T data) throws InterruptedException {
        try {
            writeLock.lock();
            while(buffer.size() == capacity){
                writeCondition.await();
            }
            buffer.offer(data);
        }finally {
            writeLock.unlock();
        }
    }

    public T consume() throws InterruptedException {
        try {
            writeLock.lock();
            while(buffer.isEmpty()){
                writeCondition.await();
            }

            return buffer.poll();
        }finally {
            writeLock.unlock();
        }
    }

    public T peek(){
        try {
            readLock.lock();
            return buffer.peek();
        }finally {
            readLock.unlock();
        }
    }
}
