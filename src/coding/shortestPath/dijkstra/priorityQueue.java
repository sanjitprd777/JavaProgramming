package coding.shortestPath.dijkstra;

import java.util.*;

public class priorityQueue {
    static class djk {
        int[] dijkstra(int s, List<Integer[]> g[], int n) {
            int INF = 1000000000;
            int[] d = new int[n];
            int[] p = new int[n];
            Arrays.fill(d, INF);
            Arrays.fill(p, -1);

            d[s] = 0;
            PriorityQueue<List<Integer>> q = new PriorityQueue<>((a, b) -> a.get(0)-b.get(0));
            q.add(Arrays.asList(0, s));
            while (!q.isEmpty()) {
                List<Integer> curr = q.poll();
                int v = curr.get(1);
                int d_v = curr.get(0);
                if (d_v != d[v]) continue;

                for (Integer[] edge : g[v]) {
                    int to = edge[0];
                    int len = edge[1];

                    if (d[v] + len < d[to]) {
                        d[to] = d[v] + len;
                        p[to] = v;
                        q.add(Arrays.asList(d[to], to));
                    }
                }
            }
            return d;
        }
    }

    public static void main(String[] args) {
        set.djk d = new set.djk();
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
