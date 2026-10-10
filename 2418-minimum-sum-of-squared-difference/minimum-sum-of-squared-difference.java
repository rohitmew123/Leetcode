class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int k = k1 + k2;
        int[] freq = new int[100001];

        long total = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
            total += diff;
            max = Math.max(max, diff);
        }

        if (total <= k) {
            return 0;
        }

        for (int d = max; d > 0 && k > 0; d--) {
            int count = Math.min(freq[d], k);

            freq[d] -= count;
            freq[d - 1] += count;
            k -= count;
        }

        long ans = 0;

        for (int d = 1; d <= max; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}