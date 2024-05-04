package MultiThreading.ProducerConsumerPattern;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        Producer producer = new Producer(blockingQueue);
        Consumer1 consumer1 = new Consumer1(blockingQueue);
        Consumer2 consumer2 = new Consumer2(blockingQueue);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer1);
        Thread thread3 = new Thread(consumer2);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
