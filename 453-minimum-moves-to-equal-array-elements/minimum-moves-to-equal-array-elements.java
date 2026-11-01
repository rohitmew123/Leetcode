import java.util.Arrays;
class Solution {
    public int minMoves(int[] nums) {
        // int n = nums.length;

        // int sum = Arrays.stream(nums).sum();

        // int min = Arrays.stream(nums).min().getAsInt();

        // return sum - n * min;

        int operation = 0;

        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
            }
        }

        for(int i=0; i<nums.length; i++) {

            operation += nums[i] - min;
        }

        return operation;
        
    }
}