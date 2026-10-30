// Problem: House Robber II
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/house-robber-ii/
// Solved on: 2026-10-30T17:13:26.342Z


class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        // Only one house
        if (n == 1) {
            return nums[0];
        }

        // Case 1: Exclude the last house
        int case1 = robLinear(nums, 0, n - 2);

        // Case 2: Exclude the first house
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    // House Robber I logic
    private int robLinear(int[] nums, int start, int end) {

        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {

            int rob = nums[i] + prev2;
            int skip = prev1;

            int current = Math.max(rob, skip);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
