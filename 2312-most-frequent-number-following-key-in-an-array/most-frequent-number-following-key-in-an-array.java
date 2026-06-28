class Solution {
    public int mostFrequent(int[] nums, int key) {
       int [] result = new int[1001];

       for(int i=0; i<nums.length-1; i++) { 

           if(nums[i] == key) {
               result[nums[i+1]]++;
            }

        }

        int ans = 0;
        for(int i=0; i<result.length; i++) {

            if(result[i] > result[ans]) {
                ans = i;
            }
        }
        return ans;
       
        
    }
}