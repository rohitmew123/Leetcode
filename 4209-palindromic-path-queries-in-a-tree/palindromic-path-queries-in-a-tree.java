import java.util.*;

class Solution {
    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        int[][] up = new int[LOG][n];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] parent = new int[n];

        Arrays.fill(parent, -1);

        // Iterative DFS with entry/exit times
        int[] nodeStack = new int[2 * n + 5];
        int[] parentStack = new int[2 * n + 5];
        boolean[] exitStack = new boolean[2 * n + 5];

        int top = 0, timer = 0;

        nodeStack[top] = 0;
        parentStack[top] = 0;
        exitStack[top++] = false;

        while (top > 0) {
            --top;
            int u = nodeStack[top];
            int p = parentStack[top];
            boolean exit = exitStack[top];

            if (exit) {
                tout[u] = timer;
                continue;
            }

            parent[u] = p;
            up[0][u] = p;
            for (int k = 1; k < LOG; k++)
                up[k][u] = up[k - 1][up[k - 1][u]];

            tin[u] = ++timer;

            nodeStack[top] = u;
            parentStack[top] = p;
            exitStack[top++] = true;

            for (int v : graph[u]) {
                if (v == p) continue;
                depth[v] = depth[u] + 1;

                nodeStack[top] = v;
                parentStack[top] = u;
                exitStack[top++] = false;
            }
        }

        Fenwick bit = new Fenwick(n + 2);
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int mask = 1 << (chars[i] - 'a');
            bit.update(tin[i], mask);
            bit.update(tout[i] + 1, mask);
        }

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            int u = Integer.parseInt(parts[1]);

            if (parts[0].equals("update")) {
                char c = parts[2].charAt(0);

                if (chars[u] != c) {
                    int mask = (1 << (chars[u] - 'a'))
                             ^ (1 << (c - 'a'));

                    bit.update(tin[u], mask);
                    bit.update(tout[u] + 1, mask);
                    chars[u] = c;
                }
            } else {
                int v = Integer.parseInt(parts[2]);
                int lca = getLCA(u, v, depth, up, LOG);

                int mask = bit.query(tin[u])
                         ^ bit.query(tin[v])
                         ^ (1 << (chars[lca] - 'a'));

                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    private int getLCA(int u, int v, int[] depth,
                       int[][] up, int LOG) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++)
            if ((diff & (1 << k)) != 0)
                u = up[k][u];

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }

    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int i, int mask) {
            for (; i <= n; i += i & -i)
                tree[i] ^= mask;
        }

        int query(int i) {
            int mask = 0;

            for (; i > 0; i -= i & -i)
                mask ^= tree[i];

            return mask;
        }
    }
}