package MultiThreading.CompletableFutureEx;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CombiningIndependentFuture {

    /*
    Consider a situation where we need to use the response of two different independent completable futures and do something.
    For ex, get user email and get a weather report, then send a weather report to users' emails.

    thenCombine:
    It takes CompletionStage & BiFunction<T, U, V> as argument.
    Used to run two futures parallel and combine results.
    thenCombineAsync()
     */

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static CompletableFuture<String> getUserEmail() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getUserEmail()");
            delay(3);
            return "abc@gmail.com";
        });
    }


    public static CompletableFuture<String> getWeather() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getWeather()");
            delay(3);
            return "Weather report";
        });
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> cf = getUserEmail().thenCombine(getWeather(), (e, w) -> {
            System.out.println("Sending email to " + e + " with report " + w);
            delay(2);
            return e + " " + w;
        });
        System.out.println("Inside main");
        delay(3);
        System.out.println(cf.join());
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime-startTime)/1000);
    }
}
