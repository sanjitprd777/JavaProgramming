package coding.segmentTree;

public class sum {

    static class stree {
        int n, t[];

        public stree(int n) {
            this.n = n;
            t = new int[4*n+1];
        }

        void build(int a[], int v, int tl, int tr) {
            if (tl==tr) {
                t[v] = a[tl];
                return;
            }
            int tm = (tl+tr)/2;
            build(a, 2*v, tl, tm);
            build(a, 2*v+1, tm+1, tr);
            t[v] = t[2*v] + t[2*v+1];
        }

        int query(int v, int tl, int tr, int l, int r) {
            if (l > r) return 0;
            if (l == tl && r == tr) return t[v];
            int tm = (tl + tr) / 2;
            return query(v*2, tl, tm, l, Math.min(r, tm))
                    + query(v*2+1, tm+1, tr, Math.max(l, tm+1), r);
        }

        void update(int v, int tl, int tr, int pos, int new_val) {
            if (tl == tr) {
                t[v] = new_val;
                return;
            }
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update(v*2, tl, tm, pos, new_val);
            else
                update(v*2+1, tm+1, tr, pos, new_val);
            t[v] = t[v*2] + t[v*2+1];
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] a = new int[]{1,2,3,4,5};
        stree s = new stree(n);
        s.build(a, 1, 0, n-1);
        System.out.println(s.query(1, 0, n-1, 2, 4));
        s.update(1, 0, n-1, 2, 10);
        System.out.println(s.query(1, 0, n-1, 2, 4));
    }
}
