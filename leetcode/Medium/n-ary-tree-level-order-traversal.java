// Problem: N-ary Tree Level Order Traversal
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/n-ary-tree-level-order-traversal/
// Solved on: 2026-11-03T17:36:35.824Z


class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node current = queue.poll();

                level.add(current.val);

                for (Node child : current.children) {
                    queue.offer(child);
                }
            }

            result.add(level);
        }

        return result;
    }
}
