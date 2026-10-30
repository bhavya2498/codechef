// Problem: Partition Equal Subset Sum
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/partition-equal-subset-sum/
// Solved on: 2026-10-30T17:24:58.174Z


class Solution {
    public boolean canPartition(int[] nums) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Odd total cannot be divided equally
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        boolean[] dp = new boolean[target + 1];

        // Sum 0 is always possible
        dp[0] = true;

        for (int num : nums) {

            // Traverse backwards
            for (int s = target; s >= num; s--) {

                dp[s] = dp[s] || dp[s - num];
            }
        }

        return dp[target];
    }
}
