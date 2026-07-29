class Solution {
    public int heightChecker(int[] heights) {
        
       int result[] = new int[heights.length];


       for(int i=0; i<heights.length; i++) {
        result[i] = heights[i];

       }

       Arrays.sort(result);
       int count = 0;

       for(int i=0; i<heights.length; i++) {
        if(heights[i] != result[i]) {
            count++;
        }
       }
       return count;

        
    }
}