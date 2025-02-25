package multithreading.ConditionEx;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionClass {

    /*
    Condition is generally used when we want to wait and signal between different threads using different conditions for the methods/functions.
    Condition is always used with a Lock. It does not exist on its own.
     */
    public void willWait(Lock lock, Condition waitCond, Condition relCond) {
        try {
            lock.lock();
            System.out.println("Inside willWait");
            try {
                waitCond.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Completed willWait");
            relCond.signal();
        } finally {
            lock.unlock();
        }
    }

    public void giveSignal(Lock lock, Condition waitCond, Condition relCond) {
        try {
            lock.lock();
            System.out.println("Inside giveSignal");
            waitCond.signal();

            try {
                relCond.await();
            } catch (InterruptedException ex) {}
            System.out.println("Completed giveSignal");
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition waitCond = lock.newCondition();
        Condition relCond = lock.newCondition();
        ConditionClass conditionClass = new ConditionClass();
        Thread thread = new Thread(() -> {
            conditionClass.willWait(lock, waitCond, relCond);
        });
        thread.start();

        TimeUnit.SECONDS.sleep(2);
        Thread thread1 = new Thread(() -> {
            conditionClass.giveSignal(lock, waitCond, relCond);
        });
        thread1.start();

//        thread.join();
//        thread1.join();
    }
}

