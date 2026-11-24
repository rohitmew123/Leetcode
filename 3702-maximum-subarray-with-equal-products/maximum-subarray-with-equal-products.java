
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long product = 1;
            long lcm = 1;

            for (int j = i; j < n; j++) {
                product *= nums[j];

                long gcd = gcd(lcm, nums[j]);
                lcm = (lcm / gcd) * nums[j];

                long gcdAll = nums[i];
                for (int k = i + 1; k <= j; k++) {
                    gcdAll = gcd(gcdAll, nums[k]);
                }

                if (product == gcdAll * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
