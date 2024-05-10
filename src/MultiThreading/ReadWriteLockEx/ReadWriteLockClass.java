package MultiThreading.ReadWriteLockEx;

import java.util.Random;

public class ReadWriteLockClass {
    /*
    ReadWriteLock is an interface that provides separate locks for reading and writing operations.

    It allows multiple threads to read the shared resource concurrently, but it allows only one thread to write to the
    resource exclusively (no other reads or writes allowed during a write operation).

    This is useful in scenarios where reads are more frequent than writes, as it can improve concurrency and performance
    by allowing multiple readers simultaneously.

    ReadWriteLock consists of two locks: a read lock (Lock readLock()) and a write lock (Lock writeLock()).

    Multiple threads can acquire the read lock simultaneously as long as no thread holds the write lock. However, only one
    thread can acquire the write lock, and it blocks other threads from acquiring either lock until the write operation completes.
     */

    public static void main(String[] args) throws InterruptedException {
        HashMapEx hashMapEx = new HashMapEx();
        Random random = new Random();
        int n = 30;
        Thread[] th = new Thread[n];
        for (int i=0; i<n;++i) {
            if (i%3!=0) {
                th[i] = new Thread(() -> {
                    hashMapEx.put(random.nextInt(5), random.nextInt(50));
                });
            } else {
                th[i] = new Thread(() -> {
                    System.out.println(hashMapEx.get(random.nextInt(5)));
                });
            }
        }

        for (int i=0;i<n;++i) {
            th[i].start();
        }
        for (int i=0;i<n;++i) {
            th[i].join();
        }
    }
}
