package MultiThreading.ThreadLocal;

public class InheritableThreadLocal {

    /*
    ThreadLocal are only accessible to the first level of Thread.
    For inner thread, we've to use InheritableThreadLocal.
     */
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        java.lang.InheritableThreadLocal<String> inheritableThreadLocal = new java.lang.InheritableThreadLocal<>();

        Thread thread = new Thread(() -> {
            System.out.println("==== Thread 1 ====");
            threadLocal.set("abc");
            inheritableThreadLocal.set("def");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {
                System.out.println("=== ChildThread ===");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            });

            childThread.start();
        });

        thread.start();
    }
}
