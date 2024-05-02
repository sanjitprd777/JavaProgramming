package MultiThreading.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPoolClass {
    /*
    By using a thread pool we can control numbers of threads running at the same time.
    A set of tasks are submitted to the blocking queue; then the first available thread from the ThreadPool
    will pick one task from queue, and so on.
     */

    static class PoolThreadRunnable implements Runnable {
        private Thread thread = null;
        private BlockingQueue taskQueue = null;
        private boolean isStopped = false;

        public PoolThreadRunnable(BlockingQueue b) {
            taskQueue = b;
        }

        public void run() {
            this.thread = Thread.currentThread();
            while (!isStopped()) {
                try {
                    Runnable runnable = (Runnable) taskQueue.take();
                    runnable.run();
                } catch (Exception e) {
//                    e.printStackTrace();
                }
            }
        }

        public synchronized void doStop() {
            isStopped = true;
            this.thread.interrupt();
        }

        public synchronized boolean isStopped() {
            return isStopped;
        }
    }

    static class ThreadPool {
        private BlockingQueue<Runnable> taskQueue = null;
        private List<PoolThreadRunnable> runnableList = new ArrayList<>();
        private boolean isStopped = false;

        public ThreadPool(int no, int max) {
            taskQueue = new ArrayBlockingQueue(max);

            for (int i=0;i<no;++i) {
                PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);

                runnableList.add(poolThreadRunnable);
            }

            for (PoolThreadRunnable runnable : runnableList) {
                new Thread(runnable).start();
            }
        }

        public synchronized void execute(Runnable task) {
            if (this.isStopped) throw new IllegalStateException("");
            this.taskQueue.offer(task);
        }

        public synchronized void stop() {
            this.isStopped = true;
            for (PoolThreadRunnable runnable : runnableList)
                runnable.doStop();
        }

        public synchronized void waitUntilAllTaskFinished() {
            while (this.taskQueue.size() > 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i=0;i<10;++i) {
            int task = i;
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " : Task " + task);
            });
        }

        threadPool.waitUntilAllTaskFinished();
        threadPool.stop();
    }
}
