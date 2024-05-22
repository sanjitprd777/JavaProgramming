package MultiThreading.SearchElementEx;

// You can import any package needed here

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution {

    private final int[] array;

    private final int target;

    // You can add any attribute needed here.


    public Solution(int[] array, int target) {
        // Init here
        this.array = array;
        this.target = target;
    }

    /**
     * 在指定范围内 查找目标值
     * Find the target value in the specified range
     * @param beginPos 查找范围的开始位置 Start position of the range
     * @param endPos 查找范围的结束位置 End position of the range
     * @return 目标值在查找范围的位置 Position of target value in the range
     */
    public int search(int beginPos, int endPos) {
        // --- write your code here ---
//        System.out.println(beginPos + " " + endPos);
        for (int i=beginPos; i<=endPos; ++i) {
            if (target == array[i])
                return i;
        }
        return -1;
    }

    /**
     * 将整个查找范围切割为N个区域
     * Cut the entire lookup range into N regions
     * 开启threadNum个线程对这些区域进行查找
     * Open threadNum to find these regions
     * @param threadNum 需要开启的线程数量 Number of opened threads
     * @return 目标值在查找范围的位置 Position of target value in the range
     */
    public int searchExecutor(int threadNum) throws ExecutionException, InterruptedException {
        // --- write your code here ---
        ExecutorService es = Executors.newFixedThreadPool(threadNum);
        int n = array.length;
        int step = n/threadNum;
        List<SearchTask> l = new ArrayList<>();
        for (int i=0;i<threadNum-1;++i) {
            l.add(new SearchTask(this, array, target, i*step, (i+1)*step-1));
        }
        l.add(new SearchTask(this, array, target, (threadNum-1)*step, n-1));
        List<Future<Integer>> ll = es.invokeAll(l);
        es.shutdown();
        for (int i=0;i<ll.size();++i) {
            try {
                int x = ll.get(i).get();
                if (x != -1)
                    return x;
            } catch (Exception ex) {
                System.out.println(i);
                System.out.println(ll.get(i));
            }
        }
        return -1;
    }
}