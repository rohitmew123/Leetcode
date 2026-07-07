class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();

        for(int i=0; i<heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        Integer[] arr = new Integer[heights.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = heights[i];
        }

        Arrays.sort(arr, Collections.reverseOrder());

        String[] ans = new String[names.length];
        for(int j=0; j<arr.length; j++) {
            ans[j] = map.get(arr[j]);
        }
        
        return ans;
        
       

        

        
    }
}