package MultiThreading;

public class ThreadDemo {

    public static Thread getThread() {
        return new Thread("ABC");
    }

    public static void main(String[] args) {
        Thread th = getThread();
        System.out.println(th.getName());
    }
}
