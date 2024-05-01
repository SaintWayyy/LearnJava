package rate_limiter;

import java.time.Duration;
import java.time.Instant;

public class FixedWindow {
    private final long rate; // 请求处理速率

    private volatile Instant lastModificationTime; // 上次修改的时间
    private volatile long counter; // 请求计数器


    public FixedWindow(long rate) {
        this.rate = rate;

        counter = 0;
        lastModificationTime = Instant.now();
    }

    public synchronized boolean tryAcquire(long newRequests){
        updateCounter();

        if(counter + newRequests > rate)
            return false;
        else {
            counter += newRequests;
            return true;
        }
    }

    public void updateCounter(){
        if(Duration.between(Instant.now(), lastModificationTime).toSeconds() >= 1){
            lastModificationTime = Instant.now();
            counter = 0;
        }
    }
}
