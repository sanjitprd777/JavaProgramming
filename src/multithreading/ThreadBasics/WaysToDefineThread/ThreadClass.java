package multithreading.ThreadBasics.WaysToDefineThread;

public class ThreadClass {

    /*
    Threads in java are managed by the underlying operating system on which JVM is running.
    Such threads are often referred to as OS level threads. OS level threads are heavy, thus consumes more memory i:e 1-2MB per thread.
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread with name: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        System.out.println("Main with name: " + Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
