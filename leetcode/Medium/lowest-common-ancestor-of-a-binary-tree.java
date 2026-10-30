// Problem: Lowest Common Ancestor of a Binary Tree
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Solved on: 2026-10-30T17:03:57.909Z

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return a node, current root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return whichever side contains p or q
        return left != null ? left : right;
    }
}
