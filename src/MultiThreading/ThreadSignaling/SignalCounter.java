package MultiThreading.ThreadSignaling;

public class SignalCounter {

    private int signals = 0;
    private int threadsWaiting = 0;

    public void doNotify() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " calling notify");
            if (this.threadsWaiting == 0)
                this.signals++;
            this.notify();
            System.out.println(Thread.currentThread().getName() + " exited notify");
        }
    }

    public void doWait() throws InterruptedException {
        synchronized (this) {
            this.signals--;
            if (this.signals>=0) {
                System.out.println(Thread.currentThread().getName() + " calling wait");
                return;
            }
            this.threadsWaiting++;
            this.wait();
            this.threadsWaiting--;
            System.out.println(Thread.currentThread().getName() + " exited wait");
        }
    }
}
