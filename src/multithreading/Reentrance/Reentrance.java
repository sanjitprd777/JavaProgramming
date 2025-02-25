package multithreading.Reentrance;

public class Reentrance {

    private int count = 0;

    public synchronized void inc() {
        this.count++;
    }

    public synchronized int incAndGet() {
        inc();
        return this.count;
    }

    /*
    Java allows the same thread holding a lock on one sync block to call another sync block from within it inside,
    or directly from outsize as well.
     */

    public static void main(String[] args) {
        Reentrance r = new Reentrance();
        System.out.println(r.incAndGet());
    }
}
