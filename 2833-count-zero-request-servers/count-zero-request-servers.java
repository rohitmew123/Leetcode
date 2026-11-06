
import java.util.*;

class Solution {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int m = logs.length;
        int q = queries.length;

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[][] sortedQueries = new int[q][2];

        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) ->
            Integer.compare(a[0], b[0]));

        int[] ans = new int[q];

        int[] freq = new int[n + 1];

        int left = 0;
        int right = 0;

        int activeServers = 0;

        for (int i = 0; i < q; i++) {

            int query = sortedQueries[i][0];
            int start = query - x;

            while (right < m && logs[right][1] <= query) {

                int server = logs[right][0];

                if (freq[server] == 0) {
                    activeServers++;
                }

                freq[server]++;
                right++;
            }

            while (left < right && logs[left][1] < start) {

                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    activeServers--;
                }

                left++;
            }

            ans[sortedQueries[i][1]] = n - activeServers;
        }

        return ans;
    }
}
