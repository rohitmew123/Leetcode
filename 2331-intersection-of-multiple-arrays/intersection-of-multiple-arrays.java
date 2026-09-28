class Solution {
    public List<Integer> intersection(int[][] nums) {

        HashSet<Integer> set = new HashSet<>();

        
        for (int i = 0; i < nums[0].length; i++) {
            set.add(nums[0][i]);
        }

        for (int i = 1; i < nums.length; i++) {

            HashSet<Integer> currentSet = new HashSet<>();

            for (int j = 0; j < nums[i].length; j++) {
                currentSet.add(nums[i][j]);
            }

            set.retainAll(currentSet);
        }

        List<Integer> result = new ArrayList<>(set);

        Collections.sort(result);

        return result;
    }
}