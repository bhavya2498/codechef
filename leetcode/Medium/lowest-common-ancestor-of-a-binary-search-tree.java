// Problem: Lowest Common Ancestor of a Binary Search Tree
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Solved on: 2026-11-03T15:45:54.786Z


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            else {
                return root;
            }
        }

        return null;
    }
}
