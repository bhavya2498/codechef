// Problem: Non-decreasing Subsequences
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/non-decreasing-subsequences/
// Solved on: 2026-11-03T17:47:20.107Z


import java.util.*;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(nums, 0, path, result);

        return result;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> path,
                           List<List<Integer>> result) {

        // A valid subsequence must have at least 2 elements
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        // Avoid choosing the same value twice at this level
        Set<Integer> used = new HashSet<>();

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at the same recursion level
            if (used.contains(nums[i])) {
                continue;
            }

            // Maintain non-decreasing order
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
                continue;
            }

            used.add(nums[i]);

            // Choose
            path.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, path, result);

            // Undo the choice
            path.remove(path.size() - 1);
        }
    }
}
