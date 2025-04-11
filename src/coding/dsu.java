package coding;

import java.util.*;

public class dsu {
	class DSU {
		int[] par, sz;

		public DSU(int n) {
			par = new int[n + 1];
			sz = new int[n + 1];
		}

		public void init() {
			for (int i = 0; i < par.length; ++i) {
				par[i] = i;
				sz[i] = 1;
			}
		}

		public int getPar(int a) {
			if (par[a] == a)
				return a;
			par[a] = getPar(par[a]);
			return par[a];
		}

		public void group(int a, int b) {
			int pa = getPar(a);
			int pb = getPar(b);
			if (pa == pb) return;
			if (sz[pa] < sz[pb]) {
				par[pb] = pa;
				sz[pa] += sz[pb];
			} else {
				par[pa] = pb;
				sz[pb] += sz[pa];
			}
		}
	}

	public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
		List<Boolean> ans = new ArrayList<>();
		DSU d = new DSU(n);
		d.init();
		for (int i = threshold + 1; i <= n; ++i) {
			for (int j = 2 * i; j <= n; j += i) {
				d.group(i, j);
			}
		}
		for (int i = 0; i < queries.length; ++i)
			ans.add(Boolean.valueOf(d.getPar(queries[i][0]) == d.getPar(queries[i][1])));
		return ans;
	}

	public static void main(String[] args) {

	}
}
