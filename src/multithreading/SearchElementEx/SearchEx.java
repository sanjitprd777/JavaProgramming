package multithreading.SearchElementEx;

import java.util.concurrent.ExecutionException;

public class SearchEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = new int[] {11, 36, 9, 23, 20, 19, 70, 58, 15, 12, 45};
        int searchVal = 58;
        int threadNum = 4;
        Solution solution = new Solution(array, searchVal);
        int resIndex = solution.searchExecutor(threadNum);
        System.out.println(resIndex);
    }
}
