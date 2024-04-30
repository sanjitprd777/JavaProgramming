package MultiThreading.ConcurrentQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentQueue {

    final List<Integer> queue = new ArrayList<>();
    Integer countAdd = 0;
    final int N = 1000000;
    int value = 0;

    void enqueue(Integer val) {
        synchronized (queue) {
            countAdd++;
            queue.add(val);
        }
    }

    synchronized void dequeue() {
        if (getSize() == 0)
            return;
        queue.remove(getSize() - 1);
    }

    Integer getSize() {
        synchronized (queue) {
            return queue.size();
        }
    }

    void start() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < N; ++i) {
            executorService.submit(() -> enqueue(value));
            value++;
        }
        executorService.shutdown();
        System.out.println(getSize() + " : " + countAdd);
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentQueue concurrentQueue = new ConcurrentQueue();
        concurrentQueue.start();
    }
}
