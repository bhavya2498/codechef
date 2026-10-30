// Problem: Sum Root to Leaf Numbers
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/sum-root-to-leaf-numbers/
// Solved on: 2026-10-30T04:16:53.412Z

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

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int sum) {

        if (node == null) {
            return 0;
        }

        // Build the number
        sum = sum * 10 + node.val;

        // If leaf node, return the number
        if (node.left == null && node.right == null) {
            return sum;
        }

        // Calculate left and right subtree sums
        return dfs(node.left, sum) + dfs(node.right, sum);
    }
}
