package MultiThreading.CyclicBarrierEx;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierEx1 {

    /*
    A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.
    CyclicBarriers are useful in programs involving a fixed sized party of threads that must occasionally wait for
    each other. The barrier is called cyclic because it can be re-used after the waiting threads are released.
    A CyclicBarrier supports an optional Runnable command that is run once per barrier point, after the last thread in
    the party arrives, but before any threads are released. This barrier action is useful for updating shared-state
    before any of the parties continue.

    In short, if we want all threads to wait at a certain point and proceed only after all threads has reached that point
    we can use CyclicBarrier.
     */

    public static void main(String[] args) {
        int nThread = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(nThread);

        for (int i=0;i<nThread;++i) {
            Thread th = new Thread(new Worker(cyclicBarrier));
            th.start();
        }
    }
}
