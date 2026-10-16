// Problem: Subarrays Distinct Element Sum of Squares II
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/
// Solved on: 2026-10-16T14:59:50.560Z


class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        long[] sum = new long[4 * n];
        long[] sq = new long[4 * n];
        long[] lazy = new long[4 * n];

        int[] last = new int[100001];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            int left = last[x]; // Previous occurrence, or 0
            update(1, 1, n, left + 1, i + 1,
                   sum, sq, lazy);

            last[x] = i + 1;
            ans = (ans + sq[1]) % MOD;
        }

        return (int) ans;
    }

    private void update(int node, int start, int end,
                        int l, int r, long[] sum,
                        long[] sq, long[] lazy) {
        if (l > end || r < start) {
            return;
        }

        if (l <= start && end <= r) {
            apply(node, start, end, sum, sq, lazy);
            return;
        }

        push(node, start, end, sum, sq, lazy);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, l, r,
               sum, sq, lazy);
        update(node * 2 + 1, mid + 1, end, l, r,
               sum, sq, lazy);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }

    private void apply(int node, int start, int end,
                       long[] sum, long[] sq, long[] lazy) {
        long len = end - start + 1L;
        long oldSum = sum[node];
        long v = lazy[node] + 1;

        sq[node] = (sq[node] + 2 * oldSum % MOD
                    + len) % MOD;
        sum[node] = (oldSum + len) % MOD;
        lazy[node] = v % MOD;
    }

    private void push(int node, int start, int end,
                      long[] sum, long[] sq, long[] lazy) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        long v = lazy[node];

        applyMany(node * 2, start, mid, v, sum, sq, lazy);
        applyMany(node * 2 + 1, mid + 1, end, v, sum, sq, lazy);

        lazy[node] = 0;
    }

    private void applyMany(int node, int start, int end, long v,
                           long[] sum, long[] sq, long[] lazy) {
        long len = end - start + 1L;
        long oldSum = sum[node];

        sq[node] = (sq[node] + 2 * v % MOD * oldSum % MOD
                    + v % MOD * v % MOD * len % MOD) % MOD;

        sum[node] = (oldSum + v % MOD * len % MOD) % MOD;
        lazy[node] = (lazy[node] + v) % MOD;
    }
}
