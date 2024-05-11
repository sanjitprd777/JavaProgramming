package MultiThreading.CyclicBarrierEx;

public class CyclicBarrierImplementation {
    // You can add any attribute needed here.
    private final int parties;
    private int count;
    private final Object lock = new Object();

    public CyclicBarrierImplementation(int n) {
        // Init here.
        this.parties = n;
        this.count = 0;
    }

    public void arriveAndWait() throws Exception {
        // --- Write your code here ---
        synchronized (lock) {
            count++;
            if (count < parties) {
                lock.wait();
            } else {
                lock.notifyAll();
                count = 0;
            }
        }
    }
}
