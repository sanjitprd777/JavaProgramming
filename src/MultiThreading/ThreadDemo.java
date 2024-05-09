package MultiThreading;

import java.util.Arrays;

public class ThreadDemo {

    public static class SortTask implements Runnable {

        // You can add any attribute needed here.
        int[] arr;

        // You can add params required to the constructor.
        public SortTask(int[] a) {
            // Init here.
            arr = a;
        }

        @Override
        public void run() {
            // --- write your code here ---
            Arrays.sort(arr);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[]{6,3,1,9};
        Thread th = new Thread(new SortTask(a));
        th.start();
        th.join();
        System.out.println(Arrays.toString(a));
    }
}
