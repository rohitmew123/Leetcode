class Solution {
    public int findPeakElement(int[] nums) {

        for(int i = 0; i < nums.length; i++) {

            boolean left = (i == 0) || (nums[i] > nums[i - 1]);
            boolean right = (i == nums.length - 1) || (nums[i] > nums[i + 1]);

            if(left && right) {
                return i;
            }
        }

        return -1;
    }
}