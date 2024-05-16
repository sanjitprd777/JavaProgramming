package MultiThreading.CountDownLatchEx;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchClass {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.countDown();

        try {
            countDownLatch.await();
        } catch (InterruptedException ex) {}
    }
}
