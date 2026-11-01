// Problem: Find All Numbers Disappeared in an Array
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Solved on: 2026-11-01T06:25:47.155Z


import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Mark the index corresponding to each number
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            nums[index] = -Math.abs(nums[index]);
        }

        // Positive values indicate missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
