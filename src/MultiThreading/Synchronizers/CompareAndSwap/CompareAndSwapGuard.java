package MultiThreading.Synchronizers.CompareAndSwap;

import java.util.concurrent.atomic.AtomicBoolean;

public class CompareAndSwapGuard {

    private final AtomicBoolean isLocked;

    public CompareAndSwapGuard() {
        isLocked = new AtomicBoolean(false);
    }

    public void lock() {
        while (!this.isLocked.compareAndSet(false, true)) {
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
    }

    public void unlock() {
        this.isLocked.set(false);
    }
}
