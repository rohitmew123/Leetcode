class Solution {
    public int maximumCount(int[] nums) {

        int max = 0;
        int min = 0;

        for(int i=0; i<nums.length; i++) {

            if(nums[i] > 0) {
                max = max + 1;

            }
            if(nums[i] < 0) {
                min = min + 1;
            }
        }
        int highest = Math.max(max, min);
        return highest;
        
        
    }
}