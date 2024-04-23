package concurrent;

public class MemoryReordering {
    volatile boolean flag = false;
    int a = 0, b = 0;
    int x = 0, y = 0;

    void run() throws InterruptedException {
        Thread one = new Thread(() -> {
            a = 1;
            x = b;
            flag = true;
        });

        Thread other = new Thread(() -> {
            b = 1;
            y = a;
            flag = true;
        });

        one.start();
        other.start();

        one.join();
        other.join();

        System.out.println(x + " " + y);
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            MemoryReordering memoryReordering = new MemoryReordering();
            memoryReordering.run();

            if (memoryReordering.x == 0 && memoryReordering.y == 0)
                break;
        }
    }
}
