package MultiThreading.ThreadLocal;

public class ThreadLocalBasic {
    /*
    The Java ThreadLocal class is a class designed to keep a single value internally.
    One single value kept per thread that accesses the thread local.

    If one thread removes its value stored in thread local, it does not affect the value of thread
    local in another thread.

    We can also create a ThreadLocal with initial value;
    Each thread creates its own initial value of thread local. They do not share the objects initialized in threadlocal.
     */

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();

        Thread thread = new Thread(() -> {
           threadLocal.set("Thread 1");
           threadLocal1.set(100);
           try {
               Thread.sleep(2000);
           } catch (InterruptedException ex) {
               ex.printStackTrace();
           }

           String value = threadLocal.get();
            Integer val = threadLocal1.get();
            System.out.println("Thread name: " + value + " : " + val);
        });

        Thread thread1 = new Thread(() -> {
            threadLocal.set("Thread 2");
            threadLocal1.set(200);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            String value = threadLocal.get();
            Integer val = threadLocal1.get();
            System.out.println("Thread name: " + value + " : " + val);
        });

        thread.start();
        thread1.start();

        class MyObject {
            int val = 20;
        }

        ThreadLocal<MyObject> threadLocal2 = new ThreadLocal<MyObject>() {
            @Override
            protected MyObject initialValue() {
                return new MyObject();
            }
        };

        ThreadLocal<MyObject> threadLocal3 = ThreadLocal.withInitial(() -> {
           return new MyObject();
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("threadlocal2: " + threadLocal2.get());
            System.out.println("threadlocal3: " + threadLocal3.get());
        });


        Thread thread3 = new Thread(() -> {
            System.out.println("threadlocal2: " + threadLocal2.get());
            System.out.println("threadlocal3: " + threadLocal3.get());
        });

        thread2.start();
        thread3.start();


        // Lazy initialization of Thread Local
        ThreadLocal<String> threadLocal4 = new ThreadLocal<>();

        String val = threadLocal4.get();
        if (val==null) {
            threadLocal4.set("Sanjit Value");
            val = threadLocal4.get();
        }

        System.out.println(val);

        /*
        Note: If we are using ThreadPool, then we have to be cautioned about threads running tasks by taking thread
        from ThreadPool. Two threads might run a different task by running them on the same thread from thread pool.
         */
    }
}
