package MultiThreading.MyThreadPool;

import java.util.concurrent.BlockingQueue;

public class ThreadPoolRunnable implements Runnable {

    private Thread thread = null;
    private BlockingQueue<Runnable> taskQueue = null;
    private Boolean isStopped = null;

    public ThreadPoolRunnable(BlockingQueue<Runnable> queue) {
        taskQueue = queue;
        isStopped = false;
    }

    public void run() {
        this.thread = Thread.currentThread();
        while (!this.isStopped) {
            try {
                taskQueue.take().run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void doStop() {
        isStopped = true;
        this.thread.interrupt();
    }
}
