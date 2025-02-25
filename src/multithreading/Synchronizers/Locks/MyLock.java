package multithreading.Synchronizers.Locks;

public class MyLock {

    boolean isLocked;

    public MyLock() {
        isLocked = false;
    }

    public synchronized void lock() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notifyAll();
    }
}
