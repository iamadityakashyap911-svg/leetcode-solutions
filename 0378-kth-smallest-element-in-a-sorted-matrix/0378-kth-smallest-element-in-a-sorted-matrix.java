import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Add first element of every row
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        // Remove smallest k - 1 elements
        for (int count = 1; count < k; count++) {
            int[] current = pq.poll();

            int row = current[1];
            int col = current[2];

            // Add next element from the same row
            if (col + 1 < n) {
                pq.offer(new int[]{
                    matrix[row][col + 1],
                    row,
                    col + 1
                });
            }
        }

        return pq.peek()[0];
    }
}