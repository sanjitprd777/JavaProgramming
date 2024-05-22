package MultiThreading.Practice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> abq = new LinkedBlockingQueue<>(2);
        abq.put("abc");
        System.out.println(abq.size());
        System.out.println(abq.remainingCapacity());
        abq.put("def");
        System.out.println(abq);
        abq.put("ghi");
        System.out.println(abq);
        System.out.println(abq.contains("def"));
        Thread th = new Thread(() -> {
            System.out.println("Hi");
        });
        th.join();
    }
}
