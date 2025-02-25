package multithreading.CountDownLatchEx;

public class CountDownLatchObject {

    private int count;
    private final Object lock = new Object();

    public CountDownLatchObject(int count) {
        this.count = count;
    }

    public void countDown() {
        synchronized (lock) {
            this.count--;
            if (this.count < 0) {
                System.out.println("Count less than zero");
                // Should throw an exception here.
            }
            else {
                lock.notifyAll();
            }
        }
    }

    public void await() {
        synchronized (lock) {
            if (this.count > 0) {
                try {
                    lock.wait();
                } catch (InterruptedException ex) {}
            }
        }
    }
}
