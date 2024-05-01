package rate_limiter;

import java.time.Duration;
import java.time.Instant;

public class TokenBucket {
    private final long capacity; // 令牌桶容量
    private final long rate; // 每秒令牌放入速率

    private volatile Instant lastModificationTime; // 上次修改的时间
    private volatile Long tokens; // 当前令牌数量

    public TokenBucket(long capacity, long rate) {
        this.capacity = capacity;
        this.rate = rate;

        tokens = capacity;
        lastModificationTime = Instant.now();
    }

    public synchronized boolean tryAcquire(long permits){
        refill();

        if(tokens < permits){
            return false;
        }
        else{
            tokens -= permits;
            return true;
        }
    }

    private synchronized void refill() {
        long elapsedTime = Duration.between(lastModificationTime, Instant.now()).toSeconds();
        tokens = Math.min(capacity, tokens + elapsedTime * rate);
        lastModificationTime = Instant.now();
    }
}
