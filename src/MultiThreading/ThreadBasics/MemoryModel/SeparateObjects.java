package MultiThreading.ThreadBasics.MemoryModel;

public class SeparateObjects {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Runnable runnable1 = new MyRunnable();
        Thread thread = new Thread(runnable, "Thread 1");
        Thread thread1 = new Thread(runnable1, "Thread 2");

        thread.start();
        thread1.start();
    }
}
