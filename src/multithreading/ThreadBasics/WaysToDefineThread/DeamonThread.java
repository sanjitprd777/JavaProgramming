package multithreading.ThreadBasics.WaysToDefineThread;

public class DeamonThread {

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getThreadGroup());
                } catch (InterruptedException ex) {
                    System.out.println("Interrupted");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Main Thread");

        Thread th = new Thread(new MyRunnable());

        // The thread-MyRunnable will not stop even if the Main thread exits.
        // To do so, we've to mark the thread as Daemon thread.
        // Also, a thread can be marked daemon only before it starts.
        th.setDaemon(true);
        th.start();

        // Note: Daemon thread stops in an undefined state that it might exit before finishing execution of a complete block of code.

        Thread.sleep(3100);
        System.out.println("Ending Main Thread");

    }
}
