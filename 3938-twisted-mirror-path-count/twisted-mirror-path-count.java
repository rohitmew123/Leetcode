
class Solution {
    public int uniquePaths(int[][] grid) {
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][] dp = new int[n + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 0) {
                    dp[j + 1][0] =
                        (int) (((long) dp[j][0] + dp[j + 1][1]) % MOD);

                    dp[j + 1][1] = dp[j + 1][0];
                } else {
                    dp[j + 1][0] = dp[j + 1][1];
                    dp[j + 1][1] = dp[j][0];
                }
            }
        }

        return dp[n][0];
    }
}

