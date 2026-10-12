import java.util.*;

class Solution {
    int MOD = 1_000_000_007;

    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[32];

        for (int num : nums) {
            for (int b = 0; b < 32; b++) {
                if ((num & (1 << b)) != 0) {
                    count[b]++;
                }
            }
        }

        long result = 0;

        while (k-- > 0) {
            long curr = 0;

            for (int b = 0; b < 32; b++) {
                if (count[b] > 0) {
                    count[b]--;
                    curr |= (1L << b);
                }
            }

            result = (result + curr * curr) % MOD;
        }

        return (int) result;
    }
}