// Problem: Optimal Division
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/optimal-division/
// Solved on: 2026-11-04T04:49:39.737Z

class Solution {
    public String optimalDivision(int[] nums) {

        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }

        StringBuilder result = new StringBuilder();

        result.append(nums[0]).append("/(");

        for (int i = 1; i < nums.length; i++) {
            result.append(nums[i]);

            if (i != nums.length - 1) {
                result.append("/");
            }
        }

        result.append(")");

        return result.toString();
    }
}