package multithreading.SearchElementEx;

import java.util.concurrent.Callable;

public class SearchTask implements Callable<Integer> {

    int searchVal, beg, end;

    int[] arr;

    final Solution solution;

    public SearchTask(Solution solution, int[] arr, int searchVal, int beg, int end) {
        this.solution = solution;
        this.arr = arr;
        this.searchVal = searchVal;
        this.beg = beg;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        return solution.search(beg, end);
    }
}

