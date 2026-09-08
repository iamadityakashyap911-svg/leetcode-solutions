import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m <= 2 || n <= 2) return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );

        boolean[][] visited = new boolean[m][n];

        // Add boundary cells
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int water = 0;

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();

            int r = cell[0];
            int c = cell[1];
            int height = cell[2];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n
                        || visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;

                int nextHeight = heightMap[nr][nc];

                if (nextHeight < height) {
                    water += height - nextHeight;
                }

                pq.offer(new int[]{
                    nr, nc, Math.max(height, nextHeight)
                });
            }
        }

        return water;
    }
}