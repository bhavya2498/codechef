// Problem: Integer Break
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/integer-break/
// Solved on: 2026-11-03T16:07:34.704Z


class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(
                    dp[i],
                    Math.max(j * (i - j), j * dp[i - j])
                );
            }
        }

        return dp[n];
    }
}
