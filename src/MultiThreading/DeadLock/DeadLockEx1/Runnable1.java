package MultiThreading.DeadLock.DeadLockEx1;

import java.util.concurrent.locks.Lock;

public class Runnable1 implements Runnable {

    private Lock lock1 = null;
    private Lock lock2 = null;

    public Runnable1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " attempting to lock Lock 1");
        lock1.lock();
        System.out.println(threadName + " locked Lock 1");

        // do some work
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println(threadName + " attempting to lock Lock 2");
        lock2.lock();
        System.out.println(threadName + " locked Lock 2");

        System.out.println(threadName + " attempting to unlock Lock 1");
        lock1.lock();
        System.out.println(threadName + " attempting to unlock Lock 2");
        lock2.lock();

        // To avoid deadlock, we must follow total ordering of locking the lock in the same sequence and unlocking them.
        // Deadlock conditions must,
        // Mutual exclusion: If one thread is using the lock, all other threads have to wait. Only one thread at a time can use the resource.
        // No Preemption: Once a thread locks the lock, it cannot be preempted by any other thread.
        // Hold & Wait: A thread holds a lock and waits for resource indefinitely held by another thread.
        // Circular Wait: Each thread holds a resource and waiting for resource held by other thread in circular manner.

    }
}
