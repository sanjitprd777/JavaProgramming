package MultiThreading.Synchronizers.BoundedSemaphore;

public class BoundedSemaphore {

    private int signals;
    private int bound;

    public BoundedSemaphore(int maxBound) {
        signals = 0;
        bound = maxBound;
    }

    public synchronized void acquire() {
        while (this.signals == this.bound) {
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        this.signals++;
    }

    public synchronized void release() {
        while (this.signals == 0) {
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        this.signals--;
        notifyAll();
    }
}
