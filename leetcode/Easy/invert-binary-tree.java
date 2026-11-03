// Problem: Invert Binary Tree
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/invert-binary-tree/
// Solved on: 2026-11-03T15:41:02.845Z


class Solution {
    public TreeNode invertTree(TreeNode root) {

        // Base case
        if (root == null) {
            return null;
        }

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
