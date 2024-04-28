package MultiThreading.ConcurrentQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentQueue {

    final List<Integer> queue = new ArrayList<>();
    final int N = 1000000;
    int value = 1;

    void enqueue (Integer val) {
        synchronized (queue) {
            queue.add(val);
        }
    }

    synchronized void dequeue() {
        if (getSize() == 0)
            return;
        queue.remove(getSize()-1);
    }

    synchronized Integer getSize() {
        return queue.size();
    }

    void start() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0;i<N;++i) {
            executorService.execute(() -> enqueue(value));
            value++;
        }
        executorService.shutdown();
        System.out.println(getSize());
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentQueue concurrentQueue = new ConcurrentQueue();
        concurrentQueue.start();
    }
}
