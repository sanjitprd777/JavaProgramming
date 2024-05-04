package MultiThreading.ExecutorServiceEx;

import java.util.concurrent.*;

public class FutureCancel {

    /*
    The number of threads depends on,
    1. Number of CPU have
    2. What type of work threads perform
    3. Desired fairness between threads

    A single CPU only executes one threads at a time.
    A single CPU having 8 cores, can execute 8 threads at a time.
    A single CPU has 8 cores, and each core can execute 2 threads, then it can execute 16 threads.


    If thread is CPU intensive, then it's good not to have more than one thread per CPU.
    If thread is IO intensive, then it's good to have more than one thread per CPU.


     */

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            System.out.println("Started exec service execution");
            try {
                Thread.sleep(3000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return "Future callable not cancelled";
        });
        System.out.println(future.isDone());

        boolean mayInterrupt = true;
        // If the task has not started when cancel is called, the task should never run.
        // If the task has already started, then the parameter determines whether the thread executing the task
        // is interrupted in an attempt to stop the task.
        boolean wasCancelled = future.cancel(mayInterrupt);
        System.out.println(wasCancelled);

        try {
            String res = future.get();
            System.out.println(res);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (CancellationException e) {
            System.out.println("Cannot call future get() since it is cancelled");
        }
        System.out.println(future.isCancelled());
        executorService.shutdown();
    }
}
