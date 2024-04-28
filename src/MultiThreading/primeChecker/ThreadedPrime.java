package MultiThreading.primeChecker;

public class ThreadedPrime {

    final Object obj = new Object();
    final int N = 100000000;
    int totalPrime = 0;
    final int Concurrency = 10;

    boolean checkPrime(int x) {
        if (((x&1)==0 || x<2) && x!=2)
            return false;
        for (int i=2;i*i<=x;++i) {
            if (x%i==0) return false;
        }
        return true;
    }

    void countPrimePerThread(int start, int end) {
        long l = System.currentTimeMillis();
        for (int i=start; i<=end; ++i) {
            int val = checkPrime(i)?1:0;
            synchronized (obj) {
                totalPrime+=val;
            }
        }
        System.out.printf("Finished thread: " + Thread.currentThread().getName() + " Range: " + start + " " + end + " ");
        System.out.println(", Primes till now: " + totalPrime + " time taken: " + (System.currentTimeMillis()-l));
    }

    void countPrime() throws InterruptedException {
        Thread[] threads = new Thread[Concurrency];
        int batchSize = N/Concurrency;
        for (int c = 0; c<Concurrency-1; ++c) {
            int begin = c*batchSize;
            int end = (c+1)*batchSize-1;
            threads[c] = new Thread(new Runnable() {
                @Override
                public void run() {
                    countPrimePerThread(begin, end);
                }
            });
        }

        threads[Concurrency-1] = new Thread(new Runnable() {
            @Override
            public void run() {
                countPrimePerThread((Concurrency-1)*batchSize, N);
            }
        });

        for (int c=0; c<Concurrency; ++c) {
            threads[c].start();
        }

        for (int c=0; c<Concurrency; ++c) {
            threads[c].join();
        }

        System.out.println("Total prime is: " + totalPrime);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadedPrime threadedPrime = new ThreadedPrime();
        long l = System.currentTimeMillis();
        threadedPrime.countPrime();
        System.out.println("Total time taken: " + (System.currentTimeMillis()-l) + "ms");

        // Total prime is: 5761455
        // Total time taken: 109999ms

        /*
        Finished thread: Thread-0 Range: 0 9999999 , Primes till now: 2583015 time taken: 37513
        Finished thread: Thread-1 Range: 10000000 19999999 , Primes till now: 4039837 time taken: 63085
        Finished thread: Thread-2 Range: 20000000 29999999 , Primes till now: 4499498 time taken: 71891
        Finished thread: Thread-3 Range: 30000000 39999999 , Primes till now: 4867627 time taken: 79360
        Finished thread: Thread-4 Range: 40000000 49999999 , Primes till now: 5290152 time taken: 88399
        Finished thread: Thread-5 Range: 50000000 59999999 , Primes till now: 5443036 time taken: 91921
        Finished thread: Thread-6 Range: 60000000 69999999 , Primes till now: 5630367 time taken: 97007
        Finished thread: Thread-7 Range: 70000000 79999999 , Primes till now: 5672243 time taken: 98261
        Finished thread: Thread-8 Range: 80000000 89999999 , Primes till now: 5743198 time taken: 100968
        Finished thread: Thread-9 Range: 90000000 100000000 , Primes till now: 5761455 time taken: 102222
        Total prime is: 5761455
        Total time taken: 102261ms
         */
    }
}
