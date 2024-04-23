package concurrent;

class Data{
    static Integer staticField;
    static ThreadLocal<Integer> staticThreadLocalField;

    Integer field = 0;
    ThreadLocal<Integer> threadLocalField = new ThreadLocal<>();

    static {
        staticField = 0;
        staticThreadLocalField = new ThreadLocal<>();
        staticThreadLocalField.set(0);
    }
}

public class MyThreadLocal {
    public static void main(String[] args) throws InterruptedException {
        // 现在一共有1个static Field，1个staticThreadLocalField， 10个Field，10个threadLocalField
        Data[] dataArray = new Data[10];
        for(int i = 0; i < 2; i++){
            dataArray[i] = new Data();
        }

        new Thread(() -> {
            // dataArray
            // 所有线程共享这1个static Field，10个Field
            // 所有线程都有属于自己的1个staticThreadLocalField，10个threadLocalField

        }).start();
    }
}
