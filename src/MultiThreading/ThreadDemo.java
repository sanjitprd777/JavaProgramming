package MultiThreading;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ThreadDemo {
    private static Semaphore l1 = new Semaphore(1);
    private static Semaphore l2 = new Semaphore(1);
    BlockingQueue<String> bq = new LinkedBlockingQueue<>();

    public ThreadDemo() {
        try {
            l2.acquire();
        } catch (InterruptedException ex) {
        }
    }

    void f1() {
        try {
            l1.acquire();
        } catch (InterruptedException ex) {
        }
        l1.release();
        l2.release();
    }

    void f2() {
        try {
            l2.acquire();
        } catch (InterruptedException ex) {
        }
        l2.release();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo th = new ThreadDemo();
        new Thread(th::f1).start();
        new Thread(th::f2).start();
        List<Integer> l = List.of(2, 2, 2, 4, 4, 4);
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(3);
        System.out.println(atomicIntegerArray);
        atomicIntegerArray.incrementAndGet(1);
        IntConsumer intConsumer = (int x) -> {
            System.out.println(x);
        };
        intConsumer.accept(3);
        Consumer<String> cs = (x) -> {
            System.out.println(x);
        };
        cs.accept("3");
        AtomicInteger ai = new AtomicInteger(0);
        ai.incrementAndGet();
        Semaphore s = new Semaphore(0);
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    }
}
