package multithreading.CompletableFutureEx;

import java.util.concurrent.*;

public class FutureEx {
    /*
    A Future class represents a future result of an asynchronous computation - a result that will eventually appear in
    Future after the processing is complete.

    Cannot complete the future manually.
    Multiple futures cannot be chained together.
    Cannot combine multiple the future together.
    No proper exception handling.
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws InterruptedException {
                TimeUnit.SECONDS.sleep(1);
                return "Hello from Future";
            }
        };

        Future<String> f = executorService.submit(callable);
//        f.complete(); // 1st disadvantage


        executorService.shutdown();

        // Do something
        System.out.println("Doing some coding...");
        String s = f.get();
        // I cannot use this return value 's' as input to another future // 2nd disadvantage
        // f.get().future2.get().future3.get() // can not combine. // 3rd disadvantage
        // Let's say we do division by 0 in callable, future would not be able to handle this exception. // 4th disadvantage

        System.out.println(s);
    }
}
