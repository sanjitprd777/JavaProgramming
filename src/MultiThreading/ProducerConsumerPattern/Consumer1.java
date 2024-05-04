package MultiThreading.ProducerConsumerPattern;

import java.util.concurrent.BlockingQueue;

public class Consumer1 implements Runnable {

    BlockingQueue<String> blockingQueue;

    public Consumer1(BlockingQueue<String> b) {
        this.blockingQueue = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " : " + blockingQueue.take());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
