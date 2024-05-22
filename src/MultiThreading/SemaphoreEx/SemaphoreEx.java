package MultiThreading.SemaphoreEx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreEx {

    /*
    A counting semaphore. Conceptually, a semaphore maintains a set of permits. Each acquires blocks if necessary until
    a permit is available, and then takes it. Each release adds a permit, potentially releasing a blocking acquirer.
    However, no actual permit objects are used; the Semaphore just keeps a count of the number available and acts
    accordingly. Semaphores are often used to restrict the number of threads that can access some (physical or logical)
     resources.
     */

    /*
    In short, suppose there are 100 (N) threads each wants to access a resource which is only 10 (K). Now, if threads
    occupy all resources, other threads must wait for a resource to get released. Once a resource is released, it is
    picked by any threads waiting for the resource.
     */

    /*
    Lock Vs Binary Semaphore
    A semaphore initialized to one, and which is used such that it only has at most one permit available, can serve as
    a mutual exclusion lock. This is more commonly known as a binary semaphore, because it only has two states:
    one permit available, or zero permits available. When used in this way, the binary semaphore has the property
    (unlike many java.util.concurrent.locks.Lock implementations), that the "lock" can be released by a thread other
    than the owner (as semaphores have no notion of ownership). This can be useful in some specialized contexts,
    such as deadlock recovery.
     */

    /*
    Fairness guarantee in Semaphore: Semaphore s = new Semaphore(3, true);
    A thread invoking acquiring can be allocated a permit ahead of a thread that has been waiting - logically the new
    thread places itself at the head of the queue of waiting threads. When fairness is set true, the semaphore guarantees
    that threads invoking any of the acquire methods are selected to obtain permits in the order in which their invocation
    of those methods was processed (first-in-first-out; FIFO). Note that FIFO ordering necessarily applies to specific
    internal points of execution within these methods. So, it is possible for one thread to invoke acquiring before another,
    but reach the ordering point after the other, and similarly upon return from the method. Also note that the untimed
    tryAcquire methods do not honor the fairness setting, but will take any permits that are available.
     */

    public static void main(String[] args) {
        int nThreads = 10;
        Semaphore semaphore = new Semaphore(3);
        ExecutorService ex = Executors.newFixedThreadPool(nThreads);

        for (int i=0;i<nThreads;++i) {
            ex.submit(new Worker(Integer.toString(i), semaphore));
        }

        ex.shutdown();
    }
}
