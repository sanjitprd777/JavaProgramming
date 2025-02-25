package multithreading.RaceCondition;

public class RaceConditionClass {
    /*
    Race condition is a situation where two or more threads access the same variable (or data) in a way where the final
    result stored in the variable depends on how thread access to the variables is scheduled.

    Occurs when,
    1. Two or more threads read and write the data or the same variable concurrently.
    2. The threads access the variable(s) using either of these patterns,
    - Check then act.
    - Read modify write: Where the modified value depends on the previously read value.
    3. The thread access to the variable(s) or data is not atomic.
     */

    static class Counter {
        private long count = 0;

        // This implementation has a problem as this is a critical condition and gets into race condition.
//        public long incAndGet() {
//            this.count++;
//            return this.count;
//        }

        // Fixing using sync block
        public synchronized void incAndGet() {
            this.count++;
        }


        public long get() {
            return this.count;
        }
    }

    public static Runnable getRunnable(Counter c, String m) {
        return () -> {
            for (int i=0;i<1000_000;++i)
                c.incAndGet();

            System.out.println(m + c.get());
        };
    }

    public static void main(String[] args) {
        Counter c = new Counter();

        Thread th = new Thread(getRunnable(c, "Thread 1: "));
        Thread th1 = new Thread(getRunnable(c, "Thread 2: "));

        th.start();
        th1.start();
    }
}
