package MultiThreading.DeadLock.DeadLockEx1;

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

        // To avoid deadlock, we must follow total ordering of locking the lock in the same sequence and unlocking them.
        // Deadlock conditions must,
        // Mutual exclusion: If one thread is using the lock, all other threads have to wait. Only one thread at a time can use the resource.
        // No Preemption: Once a thread locks the lock, it cannot be preempted by any other thread.
        // Hold & Wait: A thread holds a lock and waits for resource indefinitely held by another thread.
        // Circular Wait: Each thread holds a resource and waiting for resource held by another thread in a circular manner.

        /*
        To prevent deadlock:
        1. Lock Reordering:
           We must follow total ordering in locking the lock. So we've to lock and unlock the lock in the same order in all threads.

        2. Lock Timeout: Use lock.tryLock() with timeout and return early if not able to get lock.
           Then retry after a random amount of time.

        3. Live lock: If runnable(s) did not sleep for a random time and both retries again to lock and give up continuously,
        both will end up in a live lock situation. Hence, no thread can make progress.
         */

        /*
        To prevent deadlock:
        Build RAG (Resource allocation graph) and detect for cycle.
        If there is any cycle of length > 1, then we might get into deadlock.
         */
    }
}
