import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }

        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<long[]> pq =
            new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();

            long cost = curr[0];
            int node = (int) curr[1];
            int count = (int) curr[2];

            if (cost != dist[node][count]) continue;

            if (node == n - 1) return (int) cost;

            for (int[] edge : graph[node]) {
                int next = edge[0];
                int weight = edge[1];

                int newCount = labels.charAt(node) ==
                               labels.charAt(next) ? count + 1 : 1;

                if (newCount > k) continue;

                long newCost = cost + weight;

                if (newCost < dist[next][newCount]) {
                    dist[next][newCount] = newCost;
                    pq.offer(new long[]{newCost, next, newCount});
                }
            }
        }

        return -1;
    }
}