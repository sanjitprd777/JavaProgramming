package MultiThreading.ThreadSignaling;

public class SignalCarrier {

    public void doWait() throws InterruptedException {
        synchronized (this) {
            System.out.println("Object is waiting...");
            this.wait();
            System.out.println("Waiting exited...");
        }
    }

    public void doNotify() {
        synchronized (this) {
            System.out.println("Object is notified...");
            this.notify();
            System.out.println("Notify exited...");
        }
    }

    public void doNotifyAll() {
        synchronized (this) {
            System.out.println("Object is notified...");
            this.notifyAll();
            System.out.println("Notify exited...");
        }
    }
}
