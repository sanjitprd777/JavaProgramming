package MultiThreading.BlockingQueueEx;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> b) {
        this.blockingQueue = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // The take method is blocked until we don't have any elements
                String element = this.blockingQueue.take();
                System.out.println("Consumed: " + element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
