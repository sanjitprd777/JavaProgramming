package multithreading.CompareAndSwap;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSwapEx1 {

    AtomicInteger integer = new AtomicInteger(0);

    boolean update(int x) {
//        try {
//            Thread.sleep(1000);
//        } catch (Exception ex) {
//        }
        return integer.compareAndSet(integer.get(), x);
    }

    void execute() {
        System.out.println("Current value: " + integer.get());
        update(1);
        System.out.println("Updated value: " + integer.get());
        Thread th = new Thread(() -> update(2));
        Thread th2 = new Thread(() -> update(3));
        Thread th3 = new Thread(() -> update(4));
        Thread th4 = new Thread(() -> update(5));
        th.start();
        th2.start();
        th3.start();
        th4.start();
        System.out.println("Updated value: " + integer.get());
    }
    public static void main(String[] args) {
        CompareAndSwapEx1 compareAndSwapEx1 = new CompareAndSwapEx1();
        compareAndSwapEx1.execute();
    }
}
