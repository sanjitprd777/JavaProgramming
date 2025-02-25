package multithreading.ThreadSignaling;

public class ThreadSignalingEx {
    /*
    Thread Signaling in Java is a way to notify other threads that are currently running in JVM.
    Some popular methods are,
    wait: The current thread is paused.
    notify: Paused thread is resumed.
    notifyAll: All paused thread is resumed.

    Note: We can not call either of waits of notify on an object if it is not synchronized.
    Hence, it is a must to synchronize the object on which wait/notify is getting called.

    Once the wait is called, the lock is released from a signal object.

    notify VS notifyAll
    notify: More than one thread can call wait on the same object.

    notifyAll: All threads will be notified with notifyAll previously hold lock on the same object.
    After notifyAll, one by one all threads will resume and exit the wait method.

    Spurious Wakeup situations with wait in thread:
    A thread calling wait exits wait without any notify calls.
     */

    public static void main(String[] args) {
        SignalCarrier signalObject = new SignalCarrier();

        Thread waitThread = new Thread(() -> {
            try {
                signalObject.doWait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });


        Thread notifyThread = new Thread(signalObject::doNotify);

        waitThread.start();
        notifyThread.start();
        /*
        It is not guaranteed that notify will be called after wait.
        If notify is called before wait, notify call will be lost. This is called missed signal.
        Hence, the thread will be waiting forever. Thus, we need to record the notify calls to a thread.
         */
    }
}
