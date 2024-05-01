package concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    Lock a = new ReentrantLock();
    Lock b = new ReentrantLock();

    void deadLock(){
        new Thread(()->{
            try {
                a.lock();
                b.lock();

                // do something
            }finally {
                a.unlock();
                b.unlock();
            }

        }).start();

        new Thread(()->{
            try {
                b.lock();
                a.lock();
            }finally {
                b.unlock();
                a.unlock();
            }
        }).start();
    }

    void destroyCyclicWait(){
        // 破坏循环等待
        new Thread(()->{
            try {
                a.lock();
                b.lock();

                // do something
            }finally {
                a.unlock();
                b.unlock();
            }

        }).start();

        new Thread(()->{
            try {
                a.lock();
                b.lock();

                // do something
            }finally {
                a.unlock();
                b.unlock();
            }
        }).start();
    }

    void possessionAndWait(){
        // 破坏占有并等待
        try {
            a.lock();
            if(b.tryLock()){
                // do something
            }
            else{
                a.unlock();
            }
        }finally {
            a.unlock();
            b.unlock();
        }

        try {
            b.lock();
            if(a.tryLock()){
                // do something
            }
            else{
                a.unlock();
            }
        }finally {
            a.unlock();
            b.unlock();
        }
    }
}
