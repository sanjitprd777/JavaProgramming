package multithreading.MyThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    private BlockingQueue<Runnable> taskQueue = null;
    private final List<ThreadPoolRunnable> poolRunnable;
    private boolean isStopped;

    public ThreadPool(int noOfThread, int maxNoOfTask) {
        taskQueue = new ArrayBlockingQueue<>(maxNoOfTask);
        poolRunnable = new ArrayList<>();
        isStopped = false;

        for (int i = 0; i < noOfThread; ++i) {
            ThreadPoolRunnable threadPoolRunnable = new ThreadPoolRunnable(taskQueue);
            poolRunnable.add(threadPoolRunnable);
        }

        for (ThreadPoolRunnable runnable : poolRunnable) {
            new Thread(runnable).start();
        }
    }

    public synchronized void execute(Runnable task) {
        if (this.isStopped) throw new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.add(task);
    }

    public synchronized void shutdown() {
        this.isStopped = true;
        for (ThreadPoolRunnable runnable : poolRunnable)
            runnable.doStop();
    }

    public synchronized void waitUntilAllTasksFinished() {
        while (!this.taskQueue.isEmpty()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
            }
        }
    }
}
