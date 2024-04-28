package MultiThreading.DeadlockTotalOrdering;

public class DeadlockTotalOrdering {

    Object obj1 = new Object();
    Object obj2 = new Object();

    void execute1() {
        synchronized (obj1) {
            System.out.println("Execute1: Got lock on object1");

            System.out.println("Execute1: Waiting for lock on object2");
            synchronized (obj2) {
                System.out.println("Execute1: Got lock on object2");
            }
        }
    }

    // Total ordering is not followed, i:e first lock obj1 then lock obj2.
    void execute2() {
        synchronized (obj2) {
            System.out.println("Execute2: Got lock on object2");

            System.out.println("Execute2: Waiting for lock on object1");
            synchronized (obj1) {
                System.out.println("Execute2: Got lock on object1");
            }
        }
    }

    // Total ordering is followed, i:e first lock obj1 then lock obj2.
    void execute3() {
        synchronized (obj1) {
            System.out.println("Execute3: Got lock on object1");

            System.out.println("Execute3: Waiting for lock on object2");
            synchronized (obj2) {
                System.out.println("Execute3: Got lock on object2");
            }
        }
    }

    public static void main(String[] args) {

        DeadlockTotalOrdering deadlockTotalOrdering = new DeadlockTotalOrdering();
        int i=0;
        while (i<3) {
            Thread thread = new Thread(deadlockTotalOrdering::execute1);
            Thread thread2 = new Thread(deadlockTotalOrdering::execute3);
            thread.start();
            thread2.start();
            ++i;
        }
    }
}
