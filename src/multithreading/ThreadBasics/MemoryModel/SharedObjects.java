package multithreading.ThreadBasics.MemoryModel;

public class SharedObjects {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable, "Thread 1");
        Thread thread1 = new Thread(runnable, "Thread 2");

        thread.start();
        thread1.start();
    }
}
