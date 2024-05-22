package MultiThreading.ProducerConsumerPattern;

import java.util.concurrent.BlockingQueue;

public class Consumer2 implements Runnable {

    BlockingQueue<String> blockingQueue;

    public Consumer2(BlockingQueue<String> b) {
        this.blockingQueue = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " : " + blockingQueue.take());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        }
    }
}
