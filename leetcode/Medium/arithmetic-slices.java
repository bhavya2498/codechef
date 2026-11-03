// Problem: Arithmetic Slices
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/arithmetic-slices/
// Solved on: 2026-11-03T17:35:13.905Z


class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int dp = 0;

        for (int i = 2; i < nums.length; i++) {

            if (nums[i] - nums[i - 1] ==
                nums[i - 1] - nums[i - 2]) {

                dp++;
                count += dp;

            } else {
                dp = 0;
            }
        }

        return count;
    }
}
