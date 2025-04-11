package coding.segmentTree;

import java.util.Arrays;

class Solution {

    class stree {
        int n, t[];

        public stree(int n) {
            this.n = n;
            t = new int[4*100001+1];
        }

        public int query(int v, int tl, int tr, int l, int r) {
            if (l > r) return 0;
            if (l == tl && r == tr) return t[v];
            int tm = (tl + tr) / 2;
            return Math.max(query(v*2, tl, tm, l, Math.min(r, tm)),
                    query(v*2+1, tm+1, tr, Math.max(l, tm+1), r));
        }

        public void update(int v, int tl, int tr, int pos, int new_val) {
            if (tl == tr) {
                t[v] = new_val;
                return;
            }
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update(v*2, tl, tm, pos, new_val);
            else
                update(v*2+1, tm+1, tr, pos, new_val);
            t[v] = Math.max(t[v*2], t[v*2+1]);
        }

    }

    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length;
        stree t = new stree(n);
        int res = 1;
        for (int i=0; i<n; ++i) {
            int q = t.query(1, 0, 100001, Math.max(0, nums[i]-k), nums[i]-1) + 1;
            res = Math.max(res, q);
            t.update(1, 0, 100001, nums[i], q);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.lengthOfLIS(new int[]{1,2,3,4,5}, 2));
        System.out.println(s.lengthOfLIS(new int[]{4,2,3,6,10,1,12}, 4));
    }
}
