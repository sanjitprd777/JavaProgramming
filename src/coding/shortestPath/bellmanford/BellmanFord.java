package coding.shortestPath.bellmanford;

import java.util.*;

public class BellmanFord {

    static class bellmanford {
        void NonNegCycle(int n, int v, int t, int[][] edges) {
            int INF = 1000000001;
            int[] d = new int[n];
            Arrays.fill(d, INF);
            d[v] = 0;
            int[] p = new int[n];
            Arrays.fill(p, -1);

            for (int i=0; i < n-1; ++i) {
                boolean any = false;
                for (int[] e : edges) {
                    if (d[e[0]] < INF) {
                        if (d[e[1]] > d[e[0]] + e[2]) {
                            d[e[1]] = d[e[0]] + e[2];
                            p[e[1]] = e[0];
                            any = true;
                        }
                    }
                }
                if (!any) break;
            }

            if (d[t] == INF)
                System.out.printf("No path from " + v + " to " + t + ".");
            else {
                List<Integer> path = new ArrayList<>();
                for (int cur = t; cur != -1; cur = p[cur])
                    path.add(cur);
                Collections.reverse(path);

                System.out.printf("Path from " + v + " to " + t + ": ");
                for (int u : path)
                    System.out.printf(u + " ");
            }
            System.out.println();
        }

        void NegCycle(int n, int v, int t, int[][] edges) {
            int INF = 1000000001;
            int[] d = new int[n];
            Arrays.fill(d, INF);
            d[v] = 0;
            int[] p = new int[n];
            Arrays.fill(p, -1);
            int x = -1;
            for (int i = 0; i < n; ++i) {
                x = -1;
                for (int[] e : edges) {
                    if (d[e[0]] < INF) {
                        if (d[e[1]] > d[e[0]] + e[2]) {
                            d[e[1]] = Math.max(-INF, d[e[0]] + e[2]);
                            p[e[1]] = e[0];
                            x = e[1];
                        }
                    }
                }
            }

            if (x == -1)
                System.out.printf("No negative cycle from " + v);
            else {
                int y = x;
                for (int i = 0; i < n; ++i)
                    y = p[y];

                List<Integer> path = new ArrayList<>();
                for (int cur = y;; cur = p[cur]) {
                    path.add(cur);
                    if (cur == y && path.size() > 1)
                        break;
                }
                Collections.reverse(path);

                System.out.printf("Negative cycle: ");
                for (int u : path)
                    System.out.printf(u + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        bellmanford b = new bellmanford();
        b.NonNegCycle(4, 0, 3, new int[][]{{0,1,1}, {1,2,2}, {2,3,3}, {3,0,4}});
        b.NegCycle(4, 0, 3, new int[][]{{0,1,1}, {1,2,2}, {2,3,3}, {3,0,-7}});
    }
}
