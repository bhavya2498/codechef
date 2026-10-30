// Problem: Binary Tree Paths
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/binary-tree-paths/
// Solved on: 2026-10-30T17:05:21.246Z

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        dfs(root, "", result);

        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {

        if (node == null) {
            return;
        }

        // Add current node to the path
        if (path.isEmpty()) {
            path = String.valueOf(node.val);
        } else {
            path += "->" + node.val;
        }

        // If leaf node, save the complete path
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // Explore left and right subtrees
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }
}
