package MultiThreading.BlockingQueueEx;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueEx1 {

    /*
     A blocking queue puts elements at the end of the queue and takes an element from the beginning of the queue.
     Blocking queue is an interface, so we need implementation to use it.
     */

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);

        for (int i=0;i<3;++i) {
            System.out.println(blockingQueue.take());
        }

        /*
        Major difference: LinkedBlockingQueue doesn't provide thread fairness. Meaning the order of thread arriving at critical sectioin/lock
        and order it get access to critical section/lock can be different in LBQ.
        Create new nodes for enqueue data. Hence, performance is slow. Throughput is high bcz less memory consumption at initial.
         */
        BlockingQueue<Integer> blockingQueueL = new LinkedBlockingQueue<>(3);

        blockingQueueL.put(1);
        blockingQueueL.put(2);
        blockingQueueL.put(3);

        for (int i=0;i<3;++i) {
            System.out.println(blockingQueueL.take());
        }

    }
}
