class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int ans[] = new int[arr.length];
        ans[arr.length-1] = -1;

        for(int i=1; i<arr.length; i++) {
            int first = arr[n-i];
            int second = ans[arr.length-i];

            int max = Math.max(first, second );
            ans[arr.length-1-i] = max;
            
        }
        return ans;
        
    }
}