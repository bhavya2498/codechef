// Problem: Can I Win
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/can-i-win/
// Solved on: 2026-11-01T07:25:13.179Z


class Solution {
    byte[] memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (desiredTotal <= 0) {
            return true;
        }

        int totalSum = maxChoosableInteger *
                       (maxChoosableInteger + 1) / 2;

        if (totalSum < desiredTotal) {
            return false;
        }

        memo = new byte[1 << maxChoosableInteger];

        return solve(0, desiredTotal, maxChoosableInteger);
    }

    private boolean solve(int mask, int remaining, int max) {

        if (memo[mask] != 0) {
            return memo[mask] == 1;
        }

        for (int num = 1; num <= max; num++) {

            int bit = 1 << (num - 1);

            // Check whether this number is already used
            if ((mask & bit) == 0) {

                // We win immediately, or force opponent to lose
                if (num >= remaining ||
                    !solve(mask | bit, remaining - num, max)) {

                    memo[mask] = 1;
                    return true;
                }
            }
        }

        memo[mask] = -1;
        return false;
    }
}
