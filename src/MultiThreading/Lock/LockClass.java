package MultiThreading.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockClass {
    /*
    Lock interface represents a lock which can guard a critical section from entering more than one thread at a time.
     */

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(false); // false is optional (default value)
        // A thread can lock same lock multiple times.
        // The number of times a thread locks the lock then it has to unlock the thread same number of times.

        // If the thread is not Reentrant lock than same thread cannot lock the lock again, hence it will be
        // blocked forever. Due to this, other threads will also be locked forever.

        // Reentrant does not provide any guarantee which thread will be allowed to lock the lock again.
        // Hence, a thread might be waiting forever leading to a starvation situation.

        // Note: We can not do lock.lock() and lock.lock() twice.
        lock.lock();
        // do something...
        lock.unlock();

        // For Fairness guarantee with Reentrant lock, pass "true" in Reentrant(true) during declaration.
        Lock lock1 = new ReentrantLock(true);
        lock1.lock();
        lock1.lock(); // This is acceptable only if fairness is guaranteed with Reentrant lock.
        // do something...
        lock1.unlock();
        lock1.unlock();


        Runnable runnable = () -> {
            lockAndSleep(lock, 1000);
        };

        Thread thread = new Thread(runnable, "Thread 1");
        Thread thread1 = new Thread(runnable, "Thread 2");
        Thread thread2 = new Thread(runnable, "Thread 3");

        thread.start();
        thread1.start();
        thread2.start();

        lockInterruptibliy();

        tryLock();
    }

    private static void lockAndSleep(Lock lock, long timeMs) {
        try {
            lock.lock();
            Thread.sleep(timeMs);
            System.out.println("Current thraed: " + Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void lockInterruptibliy() {
        // The lock interruptible will only lock the lock if thread is not interrupted.
        Lock lock = new ReentrantLock();
        Thread.currentThread().interrupt();
        // If we do lock.lock() it will not work properly and wouldn't throw an exception.
        try {
            lock.lockInterruptibly(); // If a thread in interrupted and tries to lock the lock, an exception will be thrown.
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        } finally {
            lock.unlock();
        }
    }

    private static void tryLock() {
        Lock lock =  new ReentrantLock();

        try {
            boolean lockSuccess = lock.tryLock();
            System.out.println("Lock success: " + lockSuccess);
            // Useful in a situation where a thread has other work to do, and wants to get lock as well.
            // Try lock will not respect any fairness guarantees.

            // To do so, we've to provide timeout for lock.
            boolean lockSuc = lock.tryLock(1000, TimeUnit.MILLISECONDS);
            System.out.println("Lock success: " + lockSuc);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
