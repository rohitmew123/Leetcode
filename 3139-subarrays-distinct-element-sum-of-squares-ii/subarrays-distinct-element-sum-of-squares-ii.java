class Solution {
    static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        long[] sum = new long[4 * n];
        long[] squares = new long[4 * n];
        long[] lazy = new long[4 * n];

        long ans = 0;
        int[] last = new int[100001];

        for (int i = 0; i < n; i++) {
            int value = nums[i];
            int prev = last[value];
            last[value] = i + 1;

            update(1, 0, n - 1, prev, i, 1, sum, squares, lazy);
            ans = (ans + squares[1]) % MOD;
        }

        return (int) ans;
    }

    private void update(int node, int left, int right,
                        int ql, int qr, long val,
                        long[] sum, long[] squares, long[] lazy) {
        if (ql > right || qr < left) {
            return;
        }

        if (ql <= left && right <= qr) {
            long len = right - left + 1L;
            squares[node] = (squares[node]
                    + 2 * val * sum[node] + len * val * val) % MOD;
            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] += val;
            return;
        }

        int mid = (left + right) / 2;
        push(node, left, right, sum, squares, lazy);

        update(node * 2, left, mid, ql, qr, val, sum, squares, lazy);
        update(node * 2 + 1, mid + 1, right, ql, qr, val, sum, squares, lazy);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        squares[node] = (squares[node * 2] + squares[node * 2 + 1]) % MOD;
    }

    private void push(int node, int left, int right,
                      long[] sum, long[] squares, long[] lazy) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = (left + right) / 2;
        apply(node * 2, mid - left + 1L, lazy[node], sum, squares, lazy);
        apply(node * 2 + 1, right - mid, lazy[node], sum, squares, lazy);
        lazy[node] = 0;
    }

    private void apply(int node, long len, long val,
                       long[] sum, long[] squares, long[] lazy) {
        squares[node] = (squares[node]
                + 2 * val * sum[node] + len * val * val) % MOD;
        sum[node] = (sum[node] + len * val) % MOD;
        lazy[node] += val;
    }
}