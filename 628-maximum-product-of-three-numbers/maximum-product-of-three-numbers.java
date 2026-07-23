class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int largest = nums[n-1];
        int secondlargest = nums[n-2];
        int thirdlargest = nums[n-3];

        int smallest = nums[0];
        int secondsmallest = nums[1];

        int product1 = largest * secondlargest * thirdlargest;
        int product2 = smallest * secondsmallest * largest;

        if(product1 >= product2) {
            return product1;
        } else {
            return product2;

        }
        
    }
}