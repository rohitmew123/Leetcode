class Solution {
    public boolean isPossibleToSplit(int[] nums) {

        int[] count = new int[101];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;

            if (count[nums[i]] > 2) {
                return false;
            }
        }

        return true;
    }
}