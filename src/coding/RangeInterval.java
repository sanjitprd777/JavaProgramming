package coding;

import java.util.*;

/*
 */


class RangeModule {
    TreeSet<Integer[]> ts;
    public RangeModule() {
        ts = new TreeSet<>((a, b) -> a[0] - b[0]);
    }
    
    public void addRange(int left, int right) {
        Integer[] curr = new Integer[]{left, right};

        Integer[] range = ts.floor(curr);
        if (range != null && range[1] >= curr[0]) {
            curr[0] = Math.min(curr[0], range[0]);
            curr[1] = Math.max(curr[1], range[1]);
            ts.remove(range);
        }

        while(true) {
            range = ts.ceiling(curr);
            if (range != null && range[0] <= curr[1]) {
                curr[0] = Math.min(curr[0], range[0]);
                curr[1] = Math.max(curr[1], range[1]);
                ts.remove(range);
            } else {
                break;
            }
        }

        ts.add(curr);
    }
    
    public boolean queryRange(int left, int right) {
        Integer[] curr = new Integer[]{left, right};
        Integer[] range = ts.floor(curr);
        if (range != null && range[0] <= curr[0] && range[1]>= curr[1]) {
            return true;
        }

        range = ts.ceiling(curr);
        if (range != null && range[0] <= curr[0] && range[1]>= curr[1]) {
            return true;
        }

        return false;
    }
    
    public void removeRange(int left, int right) {
        Integer[] curr = new Integer[]{left, right};

        Integer[] range = ts.floor(curr);
        if (range != null && range[1] > curr[0]) {
            ts.remove(range);
            ts.add(new Integer[]{range[0], curr[0]});
            if (range[1] > curr[1]) {
                ts.add(new Integer[]{curr[1], range[1]});
            }
        }

        while(true) {
            range = ts.ceiling(curr);
            if (range != null && range[0] < curr[1]) {
                ts.remove(range);
                if (range[1] > curr[1]) {
                    ts.add(new Integer[]{curr[1], range[1]});
                }
            } else {
                break;
            }
        }
    }
}
    

public class RangeInterval {
    
    public static void main(String[] args) {
        RangeModule rm = new RangeModule();

        rm.addRange(10, 20);
        rm.removeRange(14, 16);
        System.out.println(rm.queryRange(10, 14));
        System.out.println(rm.queryRange(13, 15));
        System.out.println(rm.queryRange(16, 17));
    }
}
