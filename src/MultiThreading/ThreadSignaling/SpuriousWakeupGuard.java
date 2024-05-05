package MultiThreading.ThreadSignaling;

public class SpuriousWakeupGuard {

    Object obj = new Object();
    private boolean wasSignalled = false;

    public void doNotify() {
        synchronized (obj) {
            wasSignalled = true;
            obj.notify();
        }
    }

    public void doWait() throws InterruptedException {
        synchronized (obj) {
            while (!wasSignalled)
                obj.wait();
            // Clear the signal and continue running.
            wasSignalled = false;
        }
    }
}
