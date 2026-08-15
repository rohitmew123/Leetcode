class Solution {
    public int findLucky(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            int ele = arr[i];

            if(map.containsKey(ele) == true) {
                map.put(ele, map.get(ele)+1);

            } else {
                map.put(ele,1);
            }
        }

        int ans = -1;

        for(int key : map.keySet()) {
            if(map.get(key) == key) {
                ans = Math.max(ans, key);

            }
        }
        return ans;
    }
}