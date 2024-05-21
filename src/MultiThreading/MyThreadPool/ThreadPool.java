package MultiThreading.MyThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<ThreadPoolRunnable> poolRunnables;
    private boolean isStopped;

    public ThreadPool(int noOfThread, int maxNoOfTask) {
        taskQueue = new ArrayBlockingQueue(maxNoOfTask);
        poolRunnables = new ArrayList<>();
        isStopped = false;

        for (int i=0; i < noOfThread; ++i) {
            ThreadPoolRunnable threadPoolRunnable = new ThreadPoolRunnable(taskQueue);
            poolRunnables.add(threadPoolRunnable);
        }

        for (ThreadPoolRunnable runnable : poolRunnables) {
            new Thread(runnable).start();
        }
    }

    public synchronized void execute(Runnable task) {
        if(this.isStopped) throw new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.offer(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (ThreadPoolRunnable runnable : poolRunnables)
            runnable.doStop();
    }

    public synchronized void waitUntilAllTasksFinished() {
        while (this.taskQueue.size() > 0) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {}
        }
    }
}
