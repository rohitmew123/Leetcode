import java.util.BitSet;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        BitSet[] dp = new BitSet[n];

        for (int j = 0; j < n; j++) {
            dp[j] = new BitSet(1024);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                BitSet prev = new BitSet(1024);

                if (i == 0 && j == 0) {
                    prev.set(0);
                } else {
                    if (i > 0) {
                        prev.or(dp[j]);
                    }

                    if (j > 0) {
                        prev.or(dp[j - 1]);
                    }
                }

                BitSet curr = new BitSet(1024);

                for (int x = prev.nextSetBit(0);
                     x >= 0;
                     x = prev.nextSetBit(x + 1)) {

                    curr.set(x ^ grid[i][j]);
                }

                dp[j] = curr;
            }
        }

        return dp[n - 1].nextSetBit(0);
    }
}