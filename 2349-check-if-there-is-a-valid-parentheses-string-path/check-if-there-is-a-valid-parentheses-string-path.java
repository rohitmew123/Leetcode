class Solution {
    int m, n;
    Boolean[][][] dp;

    public boolean solve(int i, int j, int openCount, char[][] grid) {
        if(grid[i][j] == '(') {
            openCount++;

        }  else {
            openCount--;
        }

        if(openCount < 0) {
            return false;
        }

        if(i == m-1 && j == n-1) {
            return openCount == 0;
        }

        if(dp[i][j][openCount] != null) {
            return dp[i][j][openCount];
        }

        if(i+1 < m && solve(i+1, j, openCount, grid)) {
           return dp[i][j][openCount] = true;
        }

        if(j+1 < n && solve(i, j+1, openCount, grid)) {
           return dp[i][j][openCount] = true;
            
        }
        return dp[i][j][openCount] = false;
        
    }

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length; 

        if((m+n-1) % 2 == 1) {
            return false;
        }
        
        if(grid[0][0] == ')' || grid[m-1][n-1] == '(') {
            return false;
        }

        dp = new Boolean[m][n][m+n];

        return solve(0, 0, 0, grid);
 
    }
}