// Problem: Minimum Height Trees
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-height-trees/
// Solved on: 2026-11-03T16:00:33.335Z


import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            return Arrays.asList(0);
        }

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Calculate degree of each node
        int[] degree = new int[n];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            degree[i] = graph.get(i).size();

            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        // Remove leaves layer by layer
        int remaining = n;

        while (remaining > 2) {

            int size = queue.size();
            remaining -= size;

            for (int i = 0; i < size; i++) {

                int leaf = queue.poll();

                for (int neighbor : graph.get(leaf)) {

                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Remaining nodes are the centers
        return new ArrayList<>(queue);
    }
}
