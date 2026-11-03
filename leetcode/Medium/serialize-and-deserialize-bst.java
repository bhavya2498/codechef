// Problem: Serialize and Deserialize BST
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/serialize-and-deserialize-bst/
// Solved on: 2026-11-03T17:40:57.978Z


import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");
        Queue<Integer> queue = new LinkedList<>();

        for (String value : values) {
            queue.offer(Integer.parseInt(value));
        }

        return build(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(Queue<Integer> queue, int lower, int upper) {
        if (queue.isEmpty()) {
            return null;
        }

        int value = queue.peek();

        if (value < lower || value > upper) {
            return null;
        }

        queue.poll();

        TreeNode root = new TreeNode(value);

        root.left = build(queue, lower, value);
        root.right = build(queue, value, upper);

        return root;
    }
}
