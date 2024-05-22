package MultiThreading.SynchronizedBlocks.NonStaticBlock;

public class MyRunnable {
    String name = null;

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized void printName() {
        System.out.println(name);
    }

    public void setName1(String name) {
        synchronized (this) {
            this.name = name;
        }
    }

    public void printName1() {
        synchronized (this) {
            System.out.println(name);
        }
    }
}
