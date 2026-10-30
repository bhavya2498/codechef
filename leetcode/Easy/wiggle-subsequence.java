// Problem: Guess Number Higher or Lower
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/wiggle-subsequence/
// Solved on: 2026-10-30T17:19:24.494Z


class Solution {
    public int wiggleMaxLength(int[] nums) {
        int up = 1;
        int down = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }
}
