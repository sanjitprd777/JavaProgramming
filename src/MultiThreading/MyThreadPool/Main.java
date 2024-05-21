package MultiThreading.MyThreadPool;

public class Main {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i=0; i<10; ++i) {
            int taskNo = i;
            threadPool.execute(() -> {
                System.out.println("Task " + taskNo + " execute by : " + Thread.currentThread().getName());
            });
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
