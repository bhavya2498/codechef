// Problem: Heaters
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/ones-and-zeroes/
// Solved on: 2026-11-03T17:45:50.096Z


class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {

            int zeros = 0;
            int ones = 0;

            // Count zeros and ones in the current string
            for (char ch : s.toCharArray()) {
                if (ch == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            // Update DP in reverse order
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {

                    dp[i][j] = Math.max(
                        dp[i][j],
                        1 + dp[i - zeros][j - ones]
                    );
                }
            }
        }

        return dp[m][n];
    }
}
