package multithreading.DeadLock;

import java.util.concurrent.locks.Lock;

public class Runnable2 implements Runnable {

    private Lock lock1 = null;
    private Lock lock2 = null;

    public Runnable2(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        // Inorder to prevent deadlock, switch lock1 and lock2 position.
        System.out.println(threadName + " attempting to lock Lock 2");
        lock2.lock();
        System.out.println(threadName + " locked Lock 2");

        // do some work
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println(threadName + " attempting to lock Lock 1");
        lock1.lock();
        System.out.println(threadName + " locked Lock 1");

        System.out.println(threadName + " attempting to unlock Lock 2");
        lock2.lock();
        System.out.println(threadName + " attempting to unlock Lock 1");
        lock1.lock();
    }
}
