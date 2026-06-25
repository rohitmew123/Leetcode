class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        int length = nums.length; 
        int count = 0;

        for(int i=0; i<length; i++) {
            
            int frequency = 0;

            for(int j=i; j<length; j++) {

                if(nums[j] == target) {
                    frequency++;

                }
                if(frequency > (j-i+1)/2) {
                    count++;

                }
            }
        }
        return count;
        
    }
}