package MultiThreading.BlockingQueueEx;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
    }
}
