package MultiThreading.ProducerConsumerPattern;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> b) {
        this.blockingQueue = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                long l = System.currentTimeMillis();
                blockingQueue.put(Long.toString(l));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
