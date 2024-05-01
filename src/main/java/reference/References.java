package reference;

import java.lang.ref.*;


public class References {
    /**
     * The object can’t be garbage collected if it’s reachable through any strong reference
     */
    public Object strongRef = new Object();

    public ReferenceQueue<Object> refQue = new ReferenceQueue<>();

    /**
     * Objects referenced only by soft reference
     * should be cleared before the OutOfMemoryError exception is thrown
     */
    public SoftReference<Object> softRef = new SoftReference<>(new Object(), refQue);

    /**
     * Objects referenced only by weak references
     * should be cleared on the next time GC
     */
    public WeakReference<Object> weakRef = new WeakReference<>(new Object(), refQue);

    /**
     * Objects referenced only by phantom references
     * should be cleared on the next time GC
     * Phantom references must be used in conjunction with a ReferenceQueue.
     * When the garbage collector is preparing to reclaim an object and
     * finds that it still has a phantom reference,
     * it adds this phantom reference to the associated reference queue before reclaiming the object's memory.
     */
    public PhantomReference<Object> phantomRef = new PhantomReference<>(new Object(), refQue);
}
