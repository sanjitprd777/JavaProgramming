package MultiThreading.ThreadBasics.MemoryModel;

public class ThreadMemory {
    /*
    1. Each thread has their own thread stack which is not accessible by other threads. Thread stack has thread local variables.
    2. Threads have a common memory share area called heap.

    Local variables means variables defined inside the Run method of runnable.
    Local object creation is also local to each thread stack, even they share the same runnable objects.
    To make each thread share a same object, create it outside and assign it using the constructor of runnalbe class.

     */
}
