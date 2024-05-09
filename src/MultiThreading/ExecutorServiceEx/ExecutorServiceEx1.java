package MultiThreading.ExecutorServiceEx;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceEx1 {

    /*
    Executor service is an interface, hence we need to implement the interface to use it.
    Java provides two implementation classes of Executor service.

    ThreadPoolExecutor() -> It takes a task and executes it immediately.
    ScheduledThreadExecutor() -> It takes a task, schedules it to execute later.
     */

    public static void main(String[] args) {
        // Start out by having 10 threads in pool.
        int corePoolSize = 10;
        int maxPoolSize = 20; // If tasks are more than threads to handle, it inc thread count to 20
        long keepAliveTime = 3000; // If threads grown from 10 -> 20, then extra threads more than core pool size will be destroyed after 3 sec if it is idle.

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize, // Initial core pool size
                maxPoolSize, // Max up-to pool size
                keepAliveTime, // Time to live for idle threads not part of core pool size
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(128) // tasks submitted will be stored in queue.
        );
        threadPoolExecutor.submit(() -> System.out.printf("Hiii"));
        threadPoolExecutor.shutdown();
        // Both corePoolSize and maxPoolSize will be 3.
        ExecutorService threadPoolExecutor1 = Executors.newFixedThreadPool(3);

        // The shutdown method waits until all threads submitted to executor service finish execution.
        threadPoolExecutor1.shutdown();
        Executors.newSingleThreadExecutor();
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(
                3,
                3,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

        // It attempts to stop all tasks that are currently in execution. Not guarantee to stop always.
        // It immediately exits, hence all queue tasks will get canceled. All non-executed tasks will be
        // returned as a list of runnable.
        List<Runnable> runnables = threadPoolExecutor1.shutdownNow();
        // The list will contain runnable tasks in queue and gets canceled.

        // But what will happen with tasks that ExecutorService is trying to cancel, but it is unable to cancel it.
        try {
            // It can use await termination with timeout. It will wait executorService to wait for a remaining task.
            threadPoolExecutor1.awaitTermination(3000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(corePoolSize);

        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(3);
    }
}
