// Problem: Find All Duplicates in an Array
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-all-duplicates-in-an-array/
// Solved on: 2026-11-01T06:24:13.004Z


import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                // Already visited: duplicate found
                result.add(index + 1);
            } else {
                // Mark this number as visited
                nums[index] = -nums[index];
            }
        }

        return result;
    }
}
