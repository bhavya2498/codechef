// Problem: Decode Ways
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/decode-ways/
// Solved on: 2026-09-29T17:20:26.707Z

class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;

        if (s.charAt(0) != '0') {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {

            int one = s.charAt(i - 1) - '0';

            int two = (s.charAt(i - 2) - '0') * 10
                    + (s.charAt(i - 1) - '0');

            if (one >= 1 && one <= 9) {
                dp[i] += dp[i - 1];
            }

            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}