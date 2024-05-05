package MultiThreading.ThreadCongestion;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer implements Runnable {

    BlockingQueue<String> blockingQueue;
    AtomicBoolean atomicBoolean = new AtomicBoolean(true);

    public Consumer(BlockingQueue<String> b) {
        this.blockingQueue = b;
    }

    public void stop() {
        atomicBoolean.set(false);
    }

    @Override
    public void run() {
        int consumed = 0;
        while (atomicBoolean.get()) {
            if (poll() != null)
                consumed++;
        }
        while (!blockingQueue.isEmpty()) {
            if (poll() != null)
                consumed++;
        }
        System.out.println(Thread.currentThread().getName() + " consumed " + consumed + " elements");
    }

    public String poll() {
        try {
            return blockingQueue.poll(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
