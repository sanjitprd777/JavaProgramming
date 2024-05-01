package MultiThreading.SynchronizedBlocks.NonStaticBlock;

public class MyRunnable {
    String name = null;

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized void printName() {
        System.out.println(name);
    }
}
