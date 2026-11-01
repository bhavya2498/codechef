// Problem: 132 Pattern
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/132-pattern/
// Solved on: 2026-11-01T06:26:57.229Z


import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            // Found the smallest number before our 3 and 2
            if (nums[i] < second) {
                return true;
            }

            // Find a valid middle number (2)
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}
