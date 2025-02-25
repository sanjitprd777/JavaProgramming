package multithreading.CountDownLatchEx;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchEx {

    /*
    CountDownLatch is useful in case where we need to wait for a few tasks to complete N tasks, then proceed to execute
    thread waiting for completion of those tasks.
    Wait -> latch.await()
    Dec count -> latch.countDown()
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.countDown();

        try {
            countDownLatch.await();
        } catch (InterruptedException ex) {
        }

        CountDownLatchObject cdl = new CountDownLatchObject(2);

        Thread th = new Thread(() -> {
            System.out.println("Thread 1");
            cdl.await();
            System.out.println("Finish Thread 1");
        });
        th.start();

        Thread th1 = new Thread(() -> {
            System.out.println("Thread 2");
            cdl.await();
            System.out.println("Finish Thread 2");
        });
        th1.start();

        Thread th2 = new Thread(() -> {
            cdl.countDown();
        });
        th2.start();
        th2.join();

        TimeUnit.SECONDS.sleep(2);

        Thread th3 = new Thread(() -> {
            cdl.countDown();
        });
        th3.start();
        th3.join();

        th.join();
        th1.join();

        Thread th4 = new Thread(() -> {
            cdl.countDown();
        });
        th4.start();
        th4.join();


    }
}
