// Problem: Coin Change
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/coin-change/
// Solved on: 2026-11-03T16:02:42.746Z


class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Initialize all values as impossible
        Arrays.fill(dp, amount + 1);

        // Zero coins are needed for amount 0
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {
                    dp[i] = Math.min(
                        dp[i],
                        1 + dp[i - coin]
                    );
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
