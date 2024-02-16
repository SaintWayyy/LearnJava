package concurrent;

public class MyThreadLocal {
    class Worker1 implements Runnable {
        // For the same ThreadLocal, different threads can get, set, and remove their own variables
        // without affecting the variables of other threads.
        static ThreadLocal<String> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {

        }

        void printThreadLocalVariable() {
            System.out.println(threadLocal.get());
        }
    }

    class Worker2 implements Runnable {
        static int i = 0;

        @Override
        public void run() {

        }

    }

    class Worker3 implements Runnable {
        int i = 0;

        @Override
        public void run() {
            for(int i = 0; i < 5; i++){

            }
        }

    }
    public static void main(String[] args) {

    }
}
