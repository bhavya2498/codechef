// Problem: Coin Change II
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/coin-change-ii/
// Solved on: 2026-11-03T17:49:20.211Z


class Solution {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        // One way to make amount 0: choose no coins
        dp[0] = 1;

        for (int coin : coins) {

            for (int i = coin; i <= amount; i++) {

                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
