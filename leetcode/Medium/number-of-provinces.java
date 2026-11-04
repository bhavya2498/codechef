// Problem: Number of Provinces
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/number-of-provinces/
// Solved on: 2026-11-04T04:47:46.007Z


class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                dfs(i, isConnected, visited);
                provinces++;
            }
        }

        return provinces;
    }

    public void dfs(int city, int[][] isConnected, boolean[] visited) {

        visited[city] = true;

        for (int i = 0; i < isConnected.length; i++) {

            if (isConnected[city][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited);
            }
        }
    }
}
