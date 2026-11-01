// Problem: K-th Smallest in Lexicographical Order
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/
// Solved on: 2026-11-01T06:23:39.230Z


class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--; // We are already at the first number

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);

            if (steps <= k) {
                // Skip the entire subtree of current
                current++;
                k -= steps;
            } else {
                // Move deeper into the current prefix
                current *= 10;
                k--;
            }
        }

        return current;
    }

    private long countSteps(long n, long first, long next) {
        long steps = 0;

        while (first <= n) {
            steps += Math.min(n + 1, next) - first;
            first *= 10;
            next *= 10;
        }

        return steps;
    }
}
