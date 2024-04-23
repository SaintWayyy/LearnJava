package concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("Callable" + i);
            Thread.sleep(100);
        }
        return "Callable Done";
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
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
        for (int i = 0; i < 5; i++) {
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

        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        Thread callable = new Thread(futureTask);

        thread.start();
        thread.join();

        runnable.start();
        runnable.join();

        callable.start();
        callable.join();

        System.out.println(futureTask.get());
    }
}
