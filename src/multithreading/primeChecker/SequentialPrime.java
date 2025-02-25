package multithreading.primeChecker;

public class SequentialPrime {

    final int N = 100000000;
    int totalPrime = 0;

    boolean checkPrime(int x) {
        if (((x&1)==0 || x<2) && x!=2)
            return false;
        for (int i=2;i*i<=x;++i) {
            if (x%i==0)
                return false;
        }
        return true;
    }

    void countPrime() {
        for (int i=2; i<=N;++i) {
            totalPrime += checkPrime(i)?1:0;
        }
        System.out.println("Total prime is: " + totalPrime);
    }

    public static void main(String[] args) {
        SequentialPrime sequentialPrime = new SequentialPrime();
        long l = System.currentTimeMillis();
        sequentialPrime.countPrime();
        System.out.println("Total time taken: " + (System.currentTimeMillis()-l) + "ms");

        // Total prime is: 5761455
        // Total time taken: 178641ms
    }
}
