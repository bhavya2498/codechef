// Problem: Permutations
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/permutations/
// Solved on: 2026-10-30T04:04:21.691Z


import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> current,
                           List<List<Integer>> result) {

        // Base case: permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) {
                continue;
            }

            current.add(num);

            backtrack(nums, current, result);

            // Backtracking
            current.remove(current.size() - 1);
        }
    }
}
