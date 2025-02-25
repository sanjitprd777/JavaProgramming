package multithreading.SynchronizedBlocks.NonStaticBlock;

public class Main {

    public static void main(String[] args) {

        MyRunnable runnable = new MyRunnable();

        Thread th = new Thread(() -> {
           for (int i=0;i<1000;++i)
               runnable.setName(String.valueOf(i));
        });

        Thread th2 = new Thread(() -> {
            for (int i=0;i<1000;++i)
                runnable.printName();
        });

        th2.start();
        th.start();
    }
}
