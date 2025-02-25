package multithreading.CompletableFutureEx;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFutureEx1 {
    /*
    CompletableFuture implements both Future and CompletionStage interfaces.

    Provides a huge set of convenience methods for creating, chaining and combining multiple Futures.
    It also has a very comprehensive exception handling support.
    CompletableFuture executes the task in a thread obtained from ForkJoinPool.commonPool().
    We can also pass our own Executor thread pool.

    Using CompletableFuture:

    runAsync()
    It takes runnable object.
    Returns CompletableFuture<Void>

    supplyAsync()
    It takes Supplier<T>
    Returns CompletableFuture<T>

     */

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> {
            delay(2);
            System.out.println("I am Runnable... :" + Thread.currentThread().getName());
        };

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable);

        // Do own work
        System.out.println("I'm in Main... :" + Thread.currentThread().getName());

        completableFuture.join();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> completableFutureExecutor = CompletableFuture.runAsync(runnable, executorService);
        completableFutureExecutor.join();


        Supplier<String> stringSupplier = () -> {
            System.out.println("I am Supplier... :" + Thread.currentThread().getName());
            return "Supplier returned value";
        };

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(stringSupplier);
        CompletableFuture<String> completableFutureExecutor1 = CompletableFuture.supplyAsync(stringSupplier, executorService);
        System.out.println("I'm in Main2... :" + Thread.currentThread().getName());
        completableFuture1.join();
        String response = completableFutureExecutor1.get();
        System.out.println(response);
        executorService.shutdown();
    }
}
