// Problem: Smallest Missing Integer Greater Than Sequential Prefix Sum
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/
// Solved on: 2026-11-03T03:51:17.446Z


import java.util.HashSet;

class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        // Find the sum of the longest sequential prefix
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Store all array elements
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Find the smallest missing integer >= sum
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}
