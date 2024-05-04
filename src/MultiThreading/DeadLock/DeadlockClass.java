package MultiThreading.DeadLock;

import MultiThreading.DeadLock.DeadLockEx1.Runnable1;
import MultiThreading.DeadLock.DeadLockEx1.Runnable2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockClass {
    /*
    A deadlock is a situation that occurs when two threads need two or more lock inorder to do their job and
    indefinitely waiting for another thread to release the lock on resource wanted by waiting thread.
     */

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Runnable runnable1 = new Runnable1(lock1, lock2);
        Runnable runnable2 = new Runnable2(lock1, lock2);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }
}
