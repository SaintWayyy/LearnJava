package concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("Callable" + i);
            Thread.sleep(100);
        }
        return 1999;
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runnable" + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread" + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread thread = new MyThread();
        Thread runnable = new Thread(new MyRunnable());
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        Thread callable = new Thread(futureTask);

        thread.start();
        thread.join();

        runnable.start();
        runnable.join();

        callable.start();
        callable.join();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main" + i);
            Thread.sleep(100);
        }

        System.out.println(futureTask.get());
    }
}
