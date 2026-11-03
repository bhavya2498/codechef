// Problem: Sum of Left Leaves
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/sum-of-left-leaves/
// Solved on: 2026-11-03T17:33:34.628Z


class Solution {
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Check whether the left child is a leaf
        if (root.left != null &&
            root.left.left == null &&
            root.left.right == null) {

            sum += root.left.val;
        }

        // Recursively check left and right subtrees
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
