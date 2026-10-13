import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        long largeHalf = 0;
        long smallHalf = 0;

        for (int i = 0; i < n / 2; i++) {
            smallHalf += nums[i];
        }

        for (int i = n / 2; i < n; i++) {
            largeHalf += nums[i];
        }

        return largeHalf - smallHalf;
    }
}