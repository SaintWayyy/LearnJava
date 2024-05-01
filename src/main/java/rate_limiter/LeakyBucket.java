package rate_limiter;

import java.time.Duration;
import java.time.Instant;

public class LeakyBucket {
    private final long capacity; // 漏桶容量
    private final long rate; // 每秒请求处理速率

    private volatile Instant lastModificationTime; // 上次修改的时间
    private volatile Long requests; // 当前桶内请求数量

    public LeakyBucket(long capacity, long rate) {
        this.capacity = capacity;
        this.rate = rate;

        requests = 0L;
        lastModificationTime = Instant.now();
    }

    public synchronized boolean tryAcquire(long newRequests){
        leak();

        if (capacity >= requests + newRequests) {
            requests += newRequests;
            return true;
        } else {
            return false;
        }
    }

    private synchronized void leak() {
        long elapsedTime = Duration.between(lastModificationTime, Instant.now()).toSeconds();
        requests = Math.max(0, requests - elapsedTime * rate);
        lastModificationTime = Instant.now();
    }
}
