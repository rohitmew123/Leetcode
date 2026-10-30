import java.util.*;
class Solution {
    
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();

        for( int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, wt});
        }

        int[][] result = new int[n][k + 1];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        if (k < 1) return -1;

        result[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], node = curr[1], count = curr[2];

            if(d > result[node][count]) {
                continue;
            }

            if(node == n-1) {
                return d;
            }

            for (int[] vec : adj.getOrDefault(node, new ArrayList<>()))  {
                int adjNode = vec[0];
                int wt = vec[1];

                int newCount = (labels.charAt(adjNode) == labels.charAt(node)) ? count + 1 : 1;

                if(newCount > k) {
                    continue;
                }

                int newDist = d + wt;
                if(newDist < result[adjNode][newCount]) {
                    result[adjNode][newCount] = newDist;
                    pq.offer(new int[]{newDist, adjNode, newCount});
                }
            }
        }
        return -1;
        
    }
}