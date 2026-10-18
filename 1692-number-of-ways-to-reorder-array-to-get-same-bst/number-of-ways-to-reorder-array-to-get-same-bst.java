
import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    int[][] comb = new int[1001][1001];

    public int numOfWays(int[] nums) {
        int n = nums.length;

     
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        
        return (int) ((ways(list) - 1L + MOD) % MOD);
    }

    private long ways(List<Integer> nums) {
        int n = nums.size();

        if (n <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int num = nums.get(i);

            if (num < root) {
                left.add(num);
            } else {
                right.add(num);
            }
        }

        long leftWays = ways(left);
        long rightWays = ways(right);

        long combinations = comb[n - 1][left.size()];

        return combinations * leftWays % MOD * rightWays % MOD;
    }
}
