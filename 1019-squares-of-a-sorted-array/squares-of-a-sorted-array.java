class Solution {
    public int[] sortedSquares(int[] nums) {

        int arr[] = new int[nums.length];

       
        int left = 0;
        int right = nums.length-1;
        int index = nums.length-1;

        while(left <= right) {

            int leftsquare = nums[left] * nums[left];
            int  rightsquare = nums[right] * nums[right];

            if(leftsquare < rightsquare) {
                arr[index] = rightsquare;
                index--;
                right--;


            } else {
                arr[index] = leftsquare;
                index--;
                left++;
            }
        }

       
        return arr;
        
    }
}