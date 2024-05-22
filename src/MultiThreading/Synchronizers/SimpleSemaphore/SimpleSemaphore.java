package MultiThreading.Synchronizers.SimpleSemaphore;

public class SimpleSemaphore {
    private boolean signal = false;

    public synchronized void acquire() {
        this.signal = true;
        this.notify();
    }

    public synchronized void release() throws InterruptedException{
        while(!this.signal) wait();
        this.signal = false;
    }

}