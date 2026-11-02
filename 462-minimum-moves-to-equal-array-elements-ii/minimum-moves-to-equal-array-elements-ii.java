import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {

        int n = nums.length;
        int sum = 0;
        Arrays.sort(nums);

        int mid = n/2;

        for(int i=0; i<n; i++) {
            sum += Math.abs(nums[mid] - nums[i]);
            
        }
        return sum;

        
    }
}