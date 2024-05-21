package MultiThreading.Synchronizers.CompareAndSwap;

import java.util.concurrent.atomic.AtomicLong;

public class CompareAndSwapOptimisticLocking {

    private final AtomicLong count = new AtomicLong();

    public void inc() {

        boolean incSuccessful = false;
        while (!incSuccessful) {
            long value = this.count.get();
            long newValue = value + 1;

            incSuccessful = this.count.compareAndSet(value, newValue);
        }
    }

    public long getCount() {
        return this.count.get();
    }
}
