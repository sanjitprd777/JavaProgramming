package multithreading.ThreadCongestion;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadCongestionDemo {

    public static void main(String[] args) {
        int consumers = 3;
        int totalElement = 1000_000;
        BlockingQueue<String>[] blockingQueues = new ArrayBlockingQueue[consumers];
        for (int i=0;i<consumers;++i)
            blockingQueues[i] = new ArrayBlockingQueue<>(totalElement);

        Consumer[] consumerList = new Consumer[consumers];
        synchronized (ThreadCongestionDemo.class) {
            for (int i=0; i<consumers; ++i) {
                consumerList[i] = new Consumer(blockingQueues[i]);
                Thread th = new Thread(consumerList[i]);
                th.start();
            }
        }

        Thread th = new Thread(() -> {
            for (int i=0;i<totalElement; ++i) {
                try {
                    blockingQueues[i%consumers].put("" + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            synchronized (ThreadCongestionDemo.class) {
                for (int i=0;i<consumers;++i)
                    consumerList[i].stop();
            }
        });

        th.start();
    }
}
