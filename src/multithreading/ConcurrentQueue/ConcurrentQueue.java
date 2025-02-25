package multithreading.ConcurrentQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentQueue {

    Object obj = new Object();
    final List<Integer> queue = new ArrayList<>();
    AtomicInteger countAdd = new AtomicInteger(0);
    //    Integer countAdd = 0;
    final int N = 1000000;
    int value = 0;
    Lock lock = new ReentrantLock();

    void enqueue(Integer val) {
        try {
            lock.lock();
//        synchronized (obj) {
//            countAdd++;
            countAdd.incrementAndGet();
            queue.add(val);
//        }
        } finally {
            lock.unlock();

        }
    }

    synchronized void dequeue() {
        if (getSize() == 0)
            return;
        queue.remove(getSize() - 1);
    }

    Integer getSize() {
        synchronized (obj) {
            return queue.size();
        }
    }

    void start() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < N; ++i) {
            executorService.execute(() -> enqueue(value));
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
