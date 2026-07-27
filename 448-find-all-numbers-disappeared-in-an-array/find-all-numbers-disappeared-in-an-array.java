class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;
        int i = 1;
        int j = 0;

        while (i <= n && j < n) {

            if (nums[j] == i) {
                i++;
                j++;
            }
            else if (nums[j] < i) {
                j++;
            }
            else {
                list.add(i);
                i++;
            }
        }

        while (i <= n) {
            list.add(i);
            i++;
        }

        return list;
    }
}