// Problem: Stone Game II
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/stone-game-ii/
// Solved on: 2026-11-03T03:51:42.636Z


class Solution {
    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n];

        // Calculate suffix sums
        suffix[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        return solve(0, 1, piles);
    }

    private int solve(int i, int M, int[] piles) {
        int n = piles.length;

        // No piles remaining
        if (i >= n) {
            return 0;
        }

        // Current player can take all remaining piles
        if (i + 2 * M >= n) {
            return suffix[i];
        }

        // Already calculated
        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int maxStones = 0;

        // Try taking X piles
        for (int X = 1; X <= 2 * M; X++) {

            int opponentStones =
                solve(i + X, Math.max(M, X), piles);

            int currentStones = suffix[i] - opponentStones;

            maxStones = Math.max(maxStones, currentStones);
        }

        dp[i][M] = maxStones;

        return maxStones;
    }
}
