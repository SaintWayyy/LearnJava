package concurrent.lock;

import java.util.concurrent.atomic.*;

public class SpinLock {
    AtomicBoolean atomicBoolean;

    AtomicInteger atomicInteger;
    AtomicIntegerArray atomicIntegerArray;
    AtomicIntegerFieldUpdater<?> atomicIntegerFieldUpdater;

    AtomicLong atomicLong;
    AtomicLongArray atomicLongArray;
    AtomicLongFieldUpdater<?> atomicLongFieldUpdater;

    AtomicReference<?> atomicReference;
    AtomicReferenceArray<?> atomicReferenceArray;
    AtomicReferenceFieldUpdater<?, ?> atomicReferenceFieldUpdater;

    AtomicMarkableReference<?> atomicMarkableReference;
    AtomicStampedReference<?> atomicStampedReference;
}
