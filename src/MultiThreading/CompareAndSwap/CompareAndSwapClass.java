package MultiThreading.CompareAndSwap;

import java.util.concurrent.atomic.AtomicBoolean;

public class CompareAndSwapClass {
    /*
    Compare a variable value to an expected value and if the value match swap the variable value with updated value.
    Return to caller: true if value swapped, false otherwise.
     */

    /*
    Synchronized block VS Atomic Operation:
    Synchronized Block:
    In synchronized block the blocking/unblocking of thread from entering into sync block is handled at JVV/OS level.
    This operation of Java VM or OS level is expensive. When another thread frees the sync block, the JVM/OS does not know
    exactly when sync block is free for other threads. Thus, other blocked threads might be waiting for some extra time-wasting
    some potential execution time. It does not take CPU time, however.

    Atomic Operation: Fully supported by Hardware. No OS involvement is present.
    Hardware guarantees this, thus is cheaper. When a thread is executing the compareAndSwap, all other threads trying to
    also execute the compareAndSwap fail continuously. As soon as one thread completes its atomic operation, immediately one of
    the other threads starts executing compareAndSwap. Thus, threads waste no time after previous thread is freed. However,
    other threads are always using the CPU for trying to get into atomic operation again and again.
    Throughput is high, but needs more CPU cycle. Better for multiple CPUs.
     */
    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public void unlock() {
        this.atomicBoolean.set(false);
    }

    public void lock() {
        while (!this.atomicBoolean.compareAndSet(false, true)) {
            // busy wait until compareAndSet succeeds.
            // This is an atomic operation, only one thread can execute it at a time.
        }
    }
}
