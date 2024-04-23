package concurrent.lock;

import java.util.concurrent.atomic.*;

public class CAS<T> {
    public AtomicBoolean atomicBoolean;

    public AtomicInteger atomicInteger;
    public AtomicIntegerArray atomicIntegerArray;
    public AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;

    public AtomicLong atomicLong;
    public AtomicLongArray a;
    public AtomicLongFieldUpdater atomicLongFieldUpdater;

    public AtomicReference atomicReference;
    public AtomicReferenceArray atomicReferenceArray;
    public AtomicStampedReference atomicStampedReference;
    public AtomicMarkableReference atomicMarkableReference;
    public AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;

    public DoubleAccumulator doubleAccumulator;
    public DoubleAdder doubleAdder;
    public LongAccumulator longAccumulator;
    public LongAdder longAdder;

    T data;

    T read(){
        return data;
    }

    boolean upDate(T data){
        T oldData = read();
        return atomicReference.compareAndSet(oldData, data);
    }
}
