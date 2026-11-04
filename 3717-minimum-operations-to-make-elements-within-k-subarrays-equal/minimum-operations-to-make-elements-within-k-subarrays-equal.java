
import java.util.*;

class Solution {

    class MedianWindow {

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0;
        int rightSize = 0;

        long leftSum = 0;
        long rightSum = 0;

        void addLeft(int val) {
            left.put(val, left.getOrDefault(val, 0) + 1);
            leftSize++;
            leftSum += val;
        }

        void addRight(int val) {
            right.put(val, right.getOrDefault(val, 0) + 1);
            rightSize++;
            rightSum += val;
        }

        void removeLeft(int val) {
            int count = left.get(val);

            if (count == 1) {
                left.remove(val);
            } else {
                left.put(val, count - 1);
            }

            leftSize--;
            leftSum -= val;
        }

        void removeRight(int val) {
            int count = right.get(val);

            if (count == 1) {
                right.remove(val);
            } else {
                right.put(val, count - 1);
            }

            rightSize--;
            rightSum -= val;
        }

        void balance() {

            while (leftSize > rightSize + 1) {
                int val = left.lastKey();
                removeLeft(val);
                addRight(val);
            }

            while (leftSize < rightSize) {
                int val = right.firstKey();
                removeRight(val);
                addLeft(val);
            }
        }

        void add(int val) {

            if (left.isEmpty() || val <= left.lastKey()) {
                addLeft(val);
            } else {
                addRight(val);
            }

            balance();
        }

        void remove(int val) {

            if (left.containsKey(val)) {
                removeLeft(val);
            } else {
                removeRight(val);
            }

            balance();
        }

        long getCost() {

            int median = left.lastKey();

            long leftCost =
                (long) median * leftSize - leftSum;

            long rightCost =
                rightSum - (long) median * rightSize;

            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        int totalWindows = n - x + 1;

        long[] cost = new long[totalWindows];

        MedianWindow window = new MedianWindow();


        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.getCost();


        for (int start = 1; start < totalWindows; start++) {

            window.remove(nums[start - 1]);
            window.add(nums[start + x - 1]);

            cost[start] = window.getCost();
        }


        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];


        Arrays.fill(prev, 0);

        for (int count = 1; count <= k; count++) {

            long[] curr = new long[n + 1];
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                curr[i] = curr[i - 1];

                if (i >= x) {

                    int start = i - x;

                    long take = prev[start] + cost[start];

                    curr[i] = Math.min(curr[i], take);
                }
            }

            prev = curr;
        }

        return prev[n];
    }
}
