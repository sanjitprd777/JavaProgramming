package multithreading.CompletableFutureEx;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ComposingDependentFutures {

    /*
    Consider a situation where we need to use the response of one completable future into another completable future.
    thenCompose(): It is used to run two different CompletableFuture sequentially.
    It takes Function<T, R> as argument.
    It is used to chain two Futures sequentially.
    thenComposeAsync();
     */

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static CompletableFuture<String> getUserDetails() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getUserDetails() " + Thread.currentThread().getName());
            delay(2);
            return "UserDetails";
        });
    }

    public static CompletableFuture<String> getWishList(String user) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getWishList() " + Thread.currentThread().getName());
            delay(3);
            return "User's Wishlist of " + user;
        });
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> cf = getUserDetails().thenCompose(s -> getWishList(s));
        System.out.println("Do something in main");
        delay(4);
        System.out.println(cf.join());
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime-startTime)/1000);
    }
}
