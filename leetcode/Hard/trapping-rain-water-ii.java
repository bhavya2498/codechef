// Problem: Trapping Rain Water II
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/trapping-rain-water-ii/
// Solved on: 2026-10-30T17:22:34.528Z


import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3) {
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        boolean[][] visited = new boolean[m][n];

        // Add boundary cells to the min heap

        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});

            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});

            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int water = 0;

        // BFS using the minimum boundary height

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int row = current[0];
            int col = current[1];
            int height = current[2];

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n ||
                    visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;

                int neighborHeight = heightMap[nr][nc];

                // Calculate trapped water
                if (neighborHeight < height) {
                    water += height - neighborHeight;
                }

                // Add the effective boundary height
                pq.offer(new int[]{
                    nr,
                    nc,
                    Math.max(height, neighborHeight)
                });
            }
        }

        return water;
    }
}
