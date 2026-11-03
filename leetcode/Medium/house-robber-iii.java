// Problem: House Robber III
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/house-robber-iii/
// Solved on: 2026-11-03T16:06:00.685Z


class Solution {
    public int rob(TreeNode root) {
        int[] result = solve(root);
        return Math.max(result[0], result[1]);
    }

    private int[] solve(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        // Rob the current house
        int rob = root.val + left[0] + right[0];

        // Do not rob the current house
        int skip = Math.max(left[0], left[1])
                 + Math.max(right[0], right[1]);

        return new int[]{skip, rob};
    }
}
