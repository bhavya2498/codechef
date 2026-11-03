// Problem: Count the Number of Complete Components
// Platform: leetcode
// Rating/Difficulty: Unrated
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/count-the-number-of-complete-components/
// Solved on: 2026-11-03T07:45:48.120Z


import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        // Visit every connected component
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);

                int vertices = component.size();
                int edgeCount = 0;

                // Count edges in this component
                for (int node : component) {
                    edgeCount += graph.get(node).size();
                }

                edgeCount /= 2;

                // Check if component is complete
                int requiredEdges = vertices * (vertices - 1) / 2;

                if (edgeCount == requiredEdges) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int node, List<List<Integer>> graph,
                     boolean[] visited, List<Integer> component) {

        visited[node] = true;
        component.add(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }
}
