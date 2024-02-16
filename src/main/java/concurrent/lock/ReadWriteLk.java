package concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLk {

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        /**
         * read only
         * Shared lock can be placed on objects that do not have an exclusive lock already placed on them.
         * Prevents others from updating the data.
         * */
        Lock sharedLock= readWriteLock.readLock();
        Lock exclusiveLock = readWriteLock.writeLock();
    }
}
