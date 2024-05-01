package MultiThreading.ThreadBasics.MemoryModel;

public class MyRunnable implements Runnable {

    int count=0;

    @Override
    public void run() {

        Object obj = new Object();
        System.out.println("Object Reference : " + obj);

        for (int i=0;i<1000_000;++i) {
            synchronized (this) {
                this.count++;
            }
        }

        System.out.println("Current thread name: " + Thread.currentThread().getName());
        System.out.println("Current count: " + count);
    }
}
