class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {

            if(nums[i] > max) {
                max = nums[i];
            }
        }

        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += max - nums[i];

        }
        return sum;
  
    }
}