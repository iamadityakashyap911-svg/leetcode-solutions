class Solution {
    private double[][] memo;

    public double soupServings(int n) {
        if (n >= 4800) {
            return 1.0;
        }

        int m = (n + 24) / 25;
        memo = new double[m + 1][m + 1];

        return dp(m, m);
    }

    private double dp(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (memo[a][b] > 0) return memo[a][b];

        memo[a][b] = 0.25 * (
            dp(a - 4, b) +
            dp(a - 3, b - 1) +
            dp(a - 2, b - 2) +
            dp(a - 1, b - 3)
        );

        return memo[a][b];
    }
}