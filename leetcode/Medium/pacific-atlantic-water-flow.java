// Problem: Pacific Atlantic Water Flow
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/pacific-atlantic-water-flow/
// Solved on: 2026-10-30T17:25:44.252Z


import java.util.*;

class Solution {

    int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Start DFS from Pacific boundaries
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }

        List<List<Integer>> result = new ArrayList<>();

        // Find cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(
        int[][] heights,
        boolean[][] visited,
        int r,
        int c
    ) {

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= heights.length ||
                nc < 0 || nc >= heights[0].length) {
                continue;
            }

            // Reverse flow: move to equal or higher cells
            if (!visited[nr][nc] &&
                heights[nr][nc] >= heights[r][c]) {

                dfs(heights, visited, nr, nc);
            }
        }
    }
}
