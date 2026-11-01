// Problem: Distinct Subsequences II
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/distinct-subsequences-ii/
// Solved on: 2026-11-01T15:00:39.606Z


class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] dp = new long[26];

        for (char ch : s.toCharArray()) {
            long total = 1;

            for (int i = 0; i < 26; i++) {
                total = (total + dp[i]) % MOD;
            }

            dp[ch - 'a'] = total;
        }

        long ans = 0;

        for (int i = 0; i < 26; i++) {
            ans = (ans + dp[i]) % MOD;
        }

        return (int) ans;
    }
}
