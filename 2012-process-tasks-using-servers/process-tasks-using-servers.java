import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        PriorityQueue<int[]> idle = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                if (a[1] != b[1]) {
                    return Long.compare(a[1], b[1]);
                }
                return Long.compare(a[2], b[2]);
            }
        );

        for (int i = 0; i < n; i++) {
            idle.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int j = 0; j < m; j++) {

            time = Math.max(time, j);

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.poll();

                idle.offer(new int[]{
                    (int) server[1],
                    (int) server[2]
                });
            }

            if (idle.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] server = busy.poll();

                    idle.offer(new int[]{
                        (int) server[1],
                        (int) server[2]
                    });
                }
            }

            int[] selected = idle.poll();

            int weight = selected[0];
            int index = selected[1];

            ans[j] = index;

            busy.offer(new long[]{
                time + tasks[j],
                weight,
                index
            });
        }

        return ans;
    }
}