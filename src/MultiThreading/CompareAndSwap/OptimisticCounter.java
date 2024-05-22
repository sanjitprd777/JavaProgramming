package MultiThreading.CompareAndSwap;

import java.util.concurrent.atomic.AtomicLong;

public class OptimisticCounter {

    /*
    Implementing Optimistic counter using compare and set.
     */
    private AtomicLong count = new AtomicLong(0);

    public void inc() {
        // Allowing multiple thread to enter into a critical section, but only allowing one thread to update at a time.
        // Pros: Waiting threads spend less time waiting to update.
        // Cons: More CPU cycle wasted by waiting threads.
        boolean isSuccess = false;
        while (!isSuccess) {
            long val = this.count.get();
            long newVal = val + 1;
            // When success, returns true, false otherwise.
            isSuccess = this.count.compareAndSet(val, newVal);
        }
    }

    public long getCount() {
        return this.count.get();
    }
}
