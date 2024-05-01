package MultiThreading.ThreadBasics.WaysToDefineThread;

public class ThreadJoin {

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i=0;i<5;++i) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Runnable: " + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starting");
        Thread th = new Thread(new MyRunnable());
        th.setDaemon(true);
        th.start();

        // Note: The problem is that once the main thread exits all its inner thread stops execution immediately.
        // Concept: If we want a thread to finish its execution, we must call join on the thread from where its instance
        // has been initialized. Hence, it will keep the outer thread caller running until the inner thread finishes.

        // Here the main method in instancing and calling the inner thread, so we'll call thread join from here.
        th.join();

        System.out.println("Main thread ending");
    }
}
