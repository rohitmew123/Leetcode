class Solution {
    public int matrixSum(int[][] nums) {

        int row = nums.length;
        int col = nums[0].length;

        for(int i=0; i<row; i++) {
            Arrays.sort(nums[i]);
        }
        
        int sum = 0;

        for(int i=0; i < col; i++) {
            int max = Integer.MIN_VALUE;
            for(int j=0; j < row; j++) {
                
               max = Math.max(max, nums[j][i]);
                
            }
            sum = sum + max;
        }
        return sum;
    
    }
}