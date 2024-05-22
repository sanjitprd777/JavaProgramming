package MultiThreading.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> b) {
        this.blockingQueue = b;
    }

    @Override
    public void run() {
        while (true) {
            long timeMs = System.currentTimeMillis();
            try {
                // Put method is blocked until we don't have any space for putting new elements
                this.blockingQueue.put("" + timeMs);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
