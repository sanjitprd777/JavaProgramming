package MultiThreading.FalseSharing;

public class FalseSharingEx {

    /*
    False sharing is a phenomena where data variables are stored close to each other (same CPU cache line), hence when one thread updates one
    variable, it also copies the other variable, and after updating one variable, it invalidates caches for both variables.
    Hence, another thread has to its own variable again, and it also invalidates first thread variables in cache.
    Thus, some extra cost comes in computation when variables are store very close and used by different threads.
     */

    static class Counter1 {
//        @jdk.internal.vm.annotation.Contended
        // Marking a variable Contended, will instruct JVM to store variable in different CPU cache line to prevent false sharing.
        // We can put this on class, we can put this on multiple variables and also group them.
        public volatile int count1 = 0;
        public volatile int count2 = 0;
    }

    public static void main(String[] args) {
        /*
        When we use different counters, we get below time.
        Counter1 counter1 = new Counter1();
        Counter1 counter2 = new Counter1();
        Total time taken: 27608
        Total time taken: 27946
        */

        /*
        When we use different counters, we get below time.
        Counter1 counter1 = new Counter1();
        Counter1 counter2 = counter1;
        Total time taken: 38481
        Total time taken: 38921
        */

        Counter1 counter1 = new Counter1();
        Counter1 counter2 = counter1;

        long N = 1000_000_000;

        Thread thread = new Thread(() -> {
           long startTime = System.currentTimeMillis();
           for (int i=0;i<N;++i)
               counter1.count1++;
           long endTime = System.currentTimeMillis();
            System.out.println("Total time taken: " + (endTime - startTime));
        });

        Thread thread1 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int i=0;i<N;++i)
                counter2.count2++;
            long endTime = System.currentTimeMillis();
            System.out.println("Total time taken: " + (endTime - startTime));
        });

        thread.start();
        thread1.start();
    }
}
