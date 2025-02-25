package multithreading.ThreadBasics.WaysToDefineThread;

public class RunnableInterface {

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable");
        }
    }



    public static void main(String[] args) {
        Thread th = new Thread(new MyRunnable());
        th.start();

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Runnable");
            }
        });

        th2.start();

        Thread th3 = new Thread(() -> System.out.println("Lambda runnable"));
        th3.start();


        Runnable runnable = () -> System.out.println("Lambda runnable");
        Thread th4 = new Thread(runnable);
        th4.start();
    }
}
