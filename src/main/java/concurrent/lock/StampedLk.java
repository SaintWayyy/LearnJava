package concurrent.lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLk {
    StampedLock stampedLock = new StampedLock();

    void write(String data) {
        long stamp = stampedLock.writeLock();
        try {
            // write data
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    void read() {
        // gain Optimistic Read Lock
        long stamp = stampedLock.tryOptimisticRead();

        if (!stampedLock.validate(stamp)) {
            // If Optimistic Read Lock failed, acquire Pessimistic Read Lock
            stamp = stampedLock.readLock();
            try {
                // return read result
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

        // return read result
    }

    public static void main(String[] args) {

    }
}
