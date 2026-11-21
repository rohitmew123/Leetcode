
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] prev = new int[n];
        int[] newParent = new int[n];

        int[] stack = new int[2 * n];
        int top = 0;

        stack[top++] = 0;

        while (top > 0) {
            int event = stack[--top];
            int u = event / 2;
            int type = event % 2;
            int c = s.charAt(u) - 'a';

            if (type == 0) {
                prev[u] = last[c];

                newParent[u] = (prev[u] != -1)
                    ? prev[u] : parent[u];

                last[c] = u;

                stack[top++] = u * 2 + 1;

                for (int v : adj[u]) {
                    stack[top++] = v * 2;
                }
            } else {
                last[c] = prev[u];
            }
        }

        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        int[] order = new int[n];
        top = 0;
        int count = 0;

        stack[top++] = 0;

        while (top > 0) {
            int u = stack[--top];
            order[count++] = u;

            for (int v : tree[u]) {
                stack[top++] = v;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = count - 1; i > 0; i--) {
            int u = order[i];
            ans[newParent[u]] += ans[u];
        }

        return ans;
    }
}
