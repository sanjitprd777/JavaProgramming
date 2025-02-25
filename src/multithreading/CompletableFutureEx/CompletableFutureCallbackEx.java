package multithreading.CompletableFutureEx;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureCallbackEx {

    /*
    Callback to CompletableFuture:

    thenApply(Function): Transform output received from CF.
    It takes Function<T, R> as argument.
    Used for Transforming the response.
    thenApplyAsync()

    thenAccept(Consumer): Takes/Consume response as arg but doesn't return anything.
    It takes Consumer<T> as argument.
    It takes the response and doesn't return anything.
    thenAcceptAsync()

    thenRun(Runnable): Takes runnable as arg, doesn't return anything. Use to perform some operations.
    It takes Runnable as an argument.
    Doesn't take response.
    thenRunAsync()
     */

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            delay(2);
            return "Returned supplier value";
        }).thenApply(s -> {
            return "Hello " + s;
        }).thenAccept(s -> {
            System.out.println("Result: " + s);
        });

        completableFuture.join();

        CompletableFuture<Void> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            delay(2);
            return "Returned supplier value";
        }).thenApply(s -> {
            return "Hello " + s;
        }).thenRun(() -> {
            System.out.println("Task completed");
        });

        completableFuture.join();
        completableFuture1.join();
    }

}
