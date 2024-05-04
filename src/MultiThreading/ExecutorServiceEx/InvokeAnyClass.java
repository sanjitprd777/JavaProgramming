package MultiThreading.ExecutorServiceEx;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAnyClass {

    public static void main(String[] args) {
        List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(getCallable("Thread 1"));
        callableList.add(getCallable("Thread 2"));
        callableList.add(getCallable("Thread 3"));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            // Any task if fully executed, all other running task will cancel immediately.
            // Suppose we want a same result from multiple servers, take a result from any.

            String result = executorService.invokeAny(callableList);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
        try {
            List<Future<String>> futures = executorService1.invokeAll(callableList);
            for (Future f : futures)
                System.out.println(f.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService1.shutdown();

    }

    public static Callable getCallable(String msg) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return () -> Thread.currentThread().getName() + " : " + msg;
    }
}
