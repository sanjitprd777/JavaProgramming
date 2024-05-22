package MultiThreading.CompletableFutureEx;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AllOfandAnyOf {

    /*
    When we need to run all or any of the future execution.
    Both static methods take an array of CompletableFuture.

    CompletableFuture.allOf()
    Returns CompletableFuture<Void>
    Execute multiple Futures in parallel and wait for all of them to complete.

    CompletableFuture.anyOf()
    Returns CompletableFuture<Object>
    Execute multiple Futures in a parallel and returns result when any of Futures is completed.

     */

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static CompletableFuture<String> cf1() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Running CF1 in thread: " + Thread.currentThread().getName());
            delay(2);
            return "CF1";
        });
    }

    public static CompletableFuture<String> cf2() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Running CF2 in thread: " + Thread.currentThread().getName());
            delay(1);
            return "CF2";
        });
    }

    public static CompletableFuture<String> cf3() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Running CF3 in thread: " + Thread.currentThread().getName());
            delay(4);
            return "CF3";
        });
    }

    public static CompletableFuture<Integer> cf4() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Running CF3 in thread: " + Thread.currentThread().getName());
            delay(4);
            return 55;
        });
    }

    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        CompletableFuture<Void> cf = CompletableFuture.allOf(cf1(), cf2(), cf3(), cf4());
        cf.join();
        long et = System.currentTimeMillis();
        System.out.println("Total time taken for allOf (longest running): " + (et - st));


        st = System.currentTimeMillis();
        CompletableFuture<Object> cf1 = CompletableFuture.anyOf(cf1(), cf2(), cf3(), cf4());
        System.out.println(cf1.join());
        et = System.currentTimeMillis();
        System.out.println("Total time taken for anyOf (fastest running): " + (et - st));
    }

}
