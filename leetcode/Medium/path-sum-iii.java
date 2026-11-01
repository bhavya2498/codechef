// Problem: Path Sum III
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/path-sum-iii/
// Solved on: 2026-11-01T06:22:45.163Z


import java.util.*;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0L, 1);

        return dfs(root, 0L, targetSum, prefixSum);
    }

    private int dfs(TreeNode node, long currentSum,
                    int targetSum, Map<Long, Integer> prefixSum) {

        if (node == null) {
            return 0;
        }

        currentSum += node.val;

        // Find paths ending at this node
        int count = prefixSum.getOrDefault(
            currentSum - targetSum, 0
        );

        // Store current prefix sum
        prefixSum.put(
            currentSum,
            prefixSum.getOrDefault(currentSum, 0) + 1
        );

        // Explore left and right subtrees
        count += dfs(node.left, currentSum, targetSum, prefixSum);
        count += dfs(node.right, currentSum, targetSum, prefixSum);

        // Backtrack: remove current path's prefix sum
        prefixSum.put(
            currentSum,
            prefixSum.get(currentSum) - 1
        );

        return count;
    }
}
