package MultiThreading.Demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = new int[] {11, 36, 9, 23, 20, 19, 70, 58, 15, 12, 45};
        int searchVal = 58;
        int threadNum = 1;
        Solution solution = new Solution(array, searchVal);
        int resIndex = solution.searchExecutor(threadNum);
        System.out.println(resIndex);
        ReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().unlock();
    }
}
