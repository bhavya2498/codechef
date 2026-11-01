// Problem: Find X Value of Array I
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-x-value-of-array-i/
// Solved on: 2026-11-01T14:54:43.252Z


class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int rem = num % k;

            long[] next = new long[k];

            // Start a new subarray containing only this element
            next[rem]++;

            // Extend all previous subarrays
            for (int j = 0; j < k; j++) {
                int newRem = (j * rem) % k;
                next[newRem] += dp[j];
            }

            // Count all subarrays ending at this position
            for (int j = 0; j < k; j++) {
                result[j] += next[j];
            }

            dp = next;
        }

        return result;
    }
}
