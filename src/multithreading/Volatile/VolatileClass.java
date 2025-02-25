package multithreading.Volatile;

public class VolatileClass {

    /*
    A variable declared volatile must be read from/written to directly in the main memory.

    Visibility guarantee with volatile variable:
    1. When a thread writes to a volatile variable, then all other variables visible directly to the thread are written
    back to the main memory. It is forced by JVM, so we don't have to do anything.
    2. Similarly, when a volatile variable is read, it is read directly from the main memory and the same is true for all
    variables visible to the thread.

    Java compiler reorders instruction to execute lines in parallel. This might cause issues with a visibility guarantee
    with volatile variable.

    How JVM provides happens-before a guarantee for volatile variables:
    1. All writing happens to a non-volatile variable that happens before a volatile variable will remain before
    write to a volatile variable. Non-volatile variables themselves can re-order, but it cannot re-order to go after volatile variable.
    2. All reads to a volatile variable that happens before read to non-volatile variable will remain before non-volatile
    variables. Non-volatile variables can re-order themselves but cannot go before volatile variable.

    Note: Volatile variable has caused performance latency since it read/write directly from/to the main memory.

    Why cannot volatile variables be used in replacement of Atomic variables?
    Bcz, say two threads read a volatile variable at the same time and then both increment it, then we've inconsistent value.
    Two threads increment a variable only one time since they both increment value locally first then write to the main memory.
    Hence, we lose the increment by 1.

    Note: Write to volatile variable or exiting sync block flushes thread visible variables from CPU register to the main memory.
     */

    public volatile int count = 0;
    private static volatile int c = 5;
    public static void main(String[] args) {
        System.out.println(c);
    }
}
