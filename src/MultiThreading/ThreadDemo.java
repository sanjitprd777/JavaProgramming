package MultiThreading;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadDemo {

    public static Future<Long> solve(int n) {

        CompletableFuture<Long> future = new CompletableFuture<>();
        long square = (long) n * (long) n;
        if (square > Integer.MAX_VALUE) {
            future.completeExceptionally(new ArithmeticException("The square of the val exceeds the limit of the integer"));
        } else {
            future.complete(square);
        }
        return future;
    }

    public static void main(String[] args) {
        Future<Long> f = solve(100);
        try {
            System.out.println(f.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> strL = List.of("abc", "def");
        Thread th = new Thread(() -> {
            StringBuilder sb = new StringBuilder();
            for (String str : strL)
                sb.append(str);
            System.out.println(sb.toString());
        });
        th.start();
        CompletableFuture.supplyAsync(() -> {
            return "Hi";
        });
//        th.setDaemon(true);
        AtomicBoolean flag = new AtomicBoolean();
        flag.set(false);
//        th.setPriority(33);
        int x = Thread.MIN_PRIORITY;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    }
}
