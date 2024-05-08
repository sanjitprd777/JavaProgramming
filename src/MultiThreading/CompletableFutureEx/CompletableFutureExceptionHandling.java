package MultiThreading.CompletableFutureEx;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExceptionHandling {

    /*
    Two methods for handling exceptions in completable future.

    handle():
    It takes BiFunction which is executed when this stage completes either normally or exceptionally.
    Result and exception as argument.

    exceptionally():
    It takes Function as argument which is executed when stage is completed exceptionally.
    Exception as argument.
     */

    public static void main(String[] args) {
        System.out.println("In Main, handling exception via handle BiFunction");
        boolean error = false;
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            if (error)
                throw new RuntimeException("Error at future");
            return "Success at future";
        }).handle((s, e) -> {
            if (e!=null) {
                System.out.println(e.getMessage());
                return "Error string";
            }
            return s;
        });

        System.out.println(cf.join());

        boolean error1 = true;
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            if (error1)
                throw new RuntimeException("Error at future");
            return "Success at future";
        }).handle((s, e) -> {
            if (e!=null) {
                System.out.println(e.getMessage());
                return "Error string";
            }
            return s;
        });

        System.out.println(cf1.join());

        System.out.println();
        System.out.println("In Main, handling exception via exceptionally");
        boolean error2 = true;
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            if (error2)
                throw new RuntimeException("Error at future");
            return "Success at future";
        }).exceptionally(e -> {
                System.out.println(e.getMessage());
                return "Error string";
        });

        System.out.println(cf2.join());
    }
}
