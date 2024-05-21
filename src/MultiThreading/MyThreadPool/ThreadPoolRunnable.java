package MultiThreading.MyThreadPool;

import java.util.concurrent.BlockingQueue;

public class ThreadPoolRunnable implements Runnable {

    private Thread thread = null;
    private BlockingQueue taskQueue = null;
    private Boolean isStopped = null;

    public ThreadPoolRunnable(BlockingQueue queue) {
        taskQueue = queue;
        isStopped = false;
    }


    public void run() {
        this.thread = Thread.currentThread();
        while (!this.isStopped) {
            try {
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
            } catch (Exception e) {}
        }
    }

    public void doStop() {
        isStopped = true;
        this.thread.interrupt();
    }
}
