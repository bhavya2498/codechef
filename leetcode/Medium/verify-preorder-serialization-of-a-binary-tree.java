// Problem: Verify Preorder Serialization of a Binary Tree
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
// Solved on: 2026-11-03T16:04:46.742Z


class Solution {
    public boolean isValidSerialization(String preorder) {

        String[] nodes = preorder.split(",");

        int slots = 1;

        for (String node : nodes) {

            if (slots == 0) {
                return false;
            }

            if (node.equals("#")) {
                slots--;
            } else {
                slots++;
            }
        }

        return slots == 0;
    }
}
