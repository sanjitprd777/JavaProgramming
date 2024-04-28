package MultiThreading.primeChecker;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadedPrime {

    final int N = 100000000;
    final int Concurrency = 10;
    final AtomicInteger totalPrime = new AtomicInteger(0);
    final AtomicInteger currentNumber = new AtomicInteger(1);

    void checkPrime(int x) {
        if (((x&1)==0 || x<2) && x!=2) return;
        for (int i=2; i*i<=x; ++i) {
            if (x%i==0) return;
        }
        totalPrime.incrementAndGet();
    }

    void countPrimeTillN() {
        long l = System.currentTimeMillis();
        while (true) {
            checkPrime(currentNumber.incrementAndGet());
            if (currentNumber.get() > N)    break;
        }

        System.out.println("Time taken: " + (System.currentTimeMillis()-l));
    }

    void countPrime() throws InterruptedException {
        Thread[] threads = new Thread[Concurrency];
        for (int c = 0; c < Concurrency; ++c) threads[c] = new Thread(this::countPrimeTillN);
        for (int c = 0; c < Concurrency; ++c) threads[c].start();
        for (int c = 0; c < Concurrency; ++c) threads[c].join();
        System.out.println("Total prime is: " + totalPrime.get());
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadedPrime multiThreadedPrime = new MultiThreadedPrime();
        long l = System.currentTimeMillis();
        multiThreadedPrime.countPrime();
        System.out.println("Total time taken: " + (System.currentTimeMillis()-l) + "ms");

        /*
        Time taken: 78040
        Time taken: 78032
        Time taken: 78060
        Time taken: 78004
        Time taken: 78005
        Time taken: 78050
        Time taken: 77965
        Time taken: 78043
        Time taken: 77977
        Time taken: 77988
        Total prime is: 5761455
        Total time taken: 78079ms
         */
    }
}
