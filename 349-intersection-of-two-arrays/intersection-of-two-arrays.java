class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length];

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums1.length; i++) {
            set.add(nums1[i]);
        }
        
        int index = 0;
        for(int j=0; j<nums2.length; j++) {
            
            if(set.contains(nums2[j])) {
                arr[index] = nums2[j];
                index++;

                set.remove(nums2[j]);
            }

        }
        return Arrays.copyOf(arr, index);
        
    }
}