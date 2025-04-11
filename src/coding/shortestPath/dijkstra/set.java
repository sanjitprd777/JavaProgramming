package coding.shortestPath.dijkstra;

import java.util.*;

public class set {

    static class djk {
        int[] dijkstra(int s, List<Integer[]> g[], int n) {
            int INF = 1000000000;
            int[] d = new int[n];
            int[] p = new int[n];
            Arrays.fill(d, INF);
            Arrays.fill(p, -1);

            d[s] = 0;
            TreeSet<List<Integer>> st = new TreeSet<>(Comparator.comparingInt(a -> a.get(0)));
            st.add(Arrays.asList(0, s));
            while (!st.isEmpty()) {
                List<Integer> curr = st.pollFirst();
                int v = curr.get(1);

                for (Integer[] edge : g[v]) {
                    int to = edge[0];
                    int len = edge[1];

                    if (d[v] + len < d[to]) {
                        st.remove(Arrays.asList(d[to], to));
                        d[to] = d[v] + len;
                        p[to] = v;
                        st.add(Arrays.asList(d[to], to));
                    }
                }
            }
            return d;
        }
    }

    public static void main(String[] args) {
        djk d = new djk();
        int n = 5;
        List<Integer[]> g[] = new ArrayList[n];
        Arrays.setAll(g, x -> new ArrayList<>());
        g[0].add(new Integer[]{1, 100});
        g[0].add(new Integer[]{2, 500});
        g[2].add(new Integer[]{0, 500});
        g[1].add(new Integer[]{0, 100});
        g[1].add(new Integer[]{2, 100});
        g[2].add(new Integer[]{1, 100});

        int[] dis = d.dijkstra(0, g, n);
        for (int i=0; i<n; ++i)
            System.out.println(dis[i]);
    }

}
