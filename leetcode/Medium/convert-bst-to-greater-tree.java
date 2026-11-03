// Problem: Convert BST to Greater Tree
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/convert-bst-to-greater-tree/
// Solved on: 2026-11-03T17:56:13.993Z


class Solution {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }

    private void reverseInorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // 1. Visit right subtree
        reverseInorder(root.right);

        // 2. Update current node
        sum += root.val;
        root.val = sum;

        // 3. Visit left subtree
        reverseInorder(root.left);
    }
}
