package multithreading.ExecutorServiceEx;

import java.util.concurrent.*;

public class ExecutorServiceClass {

    /*
    ExecutorService executes new tasks by taking threads from pool and assigning a task to it.
    It has two implementations classes: ThreadPoolExecutor and ScheduledThreadPoolExecutor.
    It has two methods to run tasks: execute & submit.
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // execute method takes runnable interface and executes the task.
        executorService.execute(getRunnable("execute Thread 1"));
        executorService.execute(getRunnable("execute Thread 2"));
        executorService.execute(getRunnable("execute Thread 3"));

        // submit method takes runnable/callable and returns future which gives info about the status of a task.
        Future future = executorService.submit(newRunnableReturn("Runnable thread under submit, returns null"));
        Future future2 = executorService.submit(newRunnableReturn("Runnable thread under submit, returns string"), "AR");
        try {
            System.out.println("Is future1 completed: " + future.isDone());
            System.out.println("Is future2 completed: " + future.isDone());

            // Note: Future get() method blocks the thread until we get the response of runnable execution completed.
            // Since for runnable, we haven't had anything in response
            System.out.println("Result of future1: " + future.get());
            System.out.println("Result of future2: " + future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // callable method returns
        Future future3 = executorService.submit(getCallable("Callable thread under submit, returns string"));
        /*
        Internal working of Task and future: When a task is submitted to thread pool, the thread pool creates a future and connects it
        to the task internally. When the task finishes, it updates the future with any returned value. Hence, the future is returned even
        before the task is executed.
         */
        try {
            System.out.println("Is future3 completed: " + future3.isDone());

            // Note: Future get() method blocks the thread until we get the response of callable execution completed.
            System.out.println("Result of future3: " + future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        /*
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "";
            }
        };
        */
    }

    private static Runnable getRunnable(String msg) {
        return () -> {
            String compMsg = Thread.currentThread().getName() + " " + msg;
            System.out.println(compMsg);
        };
    }

    private static Runnable newRunnableReturn(String msg) {
        return () -> {
            String compMsg = Thread.currentThread().getName() + " " + msg;
            System.out.println(compMsg);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    private static Callable<String> getCallable(String msg) {
        return new Callable() {
            @Override
            public Object call() {
                return Thread.currentThread().getName() + " " + msg;
            }
        };
    }
}
