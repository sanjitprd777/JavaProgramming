package coding;

import java.util.*;

public class code {
    private static boolean checkBFS(int n, List<Integer[]> adj[], int k, int src, int dst) {
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[n+1];
        Arrays.fill(vis, -1);
        q.add(src);
        vis[src]=1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == dst) {
                return  true;
            }
            for (Integer [] edge : adj[curr]) {
                if (edge[1] > k || vis[edge[0]]!=-1)  continue;
                q.add(edge[0]);
                vis[edge[0]]=1;
            }
        }
        return  false;
    }

    private static int findMinStressPath(int n, int m, int[][] edges, int src, int dst) {
        int low = Integer.MAX_VALUE;
        int high = -1;
        List<Integer[]> adj[] = new ArrayList[n+1];
        Arrays.setAll(adj, a -> new ArrayList<>());

        for (int i=0; i<m; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            low = Math.min(low, w);
            high = Math.max(high, w);
            adj[u].add(new Integer[]{v, w});
            adj[v].add(new Integer[]{u, w});
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (checkBFS(n, adj, mid, src, dst)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int[][] edges = new int[][]{{1,2,10}, {2,3,5}, {1,4,15}, {4,3,2}, {1,5,4}, {5,3,6}};
        int source = 1;
        int destination = 3;
        System.out.println(findMinStressPath(n,m,edges, source, destination));
    }
}
