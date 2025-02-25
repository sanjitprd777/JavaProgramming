package multithreading.SemaphoreEx;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {

    Semaphore semaphore;
    String name;

    public Worker(String name, Semaphore s) {
        this.name = name;
        this.semaphore = s;
    }

    public void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread: " + name + " waiting for resource");
        delay(3);
        try {
            semaphore.acquire();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Thread: " + name + " acquired the resource");
        delay(3);
        System.out.println("Thread: " + name + " releasing the resource");
        semaphore.release();
    }
}
