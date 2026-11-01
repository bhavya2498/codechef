// Problem: Find Bottom Left Tree Value
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-bottom-left-tree-value/
// Solved on: 2026-11-01T08:00:15.369Z

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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int result = root.val;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            result = node.val;

            // Add right first, then left
            if (node.right != null) {
                queue.offer(node.right);
            }

            if (node.left != null) {
                queue.offer(node.left);
            }
        }

        return result;
    }
}