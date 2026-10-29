// Problem: Minimum XOR Path in a Grid
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-xor-path-in-a-grid/
// Solved on: 2026-10-29T17:02:18.732Z


class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        boolean[][][] seen = new boolean[m][n][1024];

        dp[0][0] = grid[0][0];
        seen[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                if (i > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (seen[i - 1][j][x]) {
                            seen[i][j][x ^ grid[i][j]] = true;
                        }
                    }
                }

                if (j > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (seen[i][j - 1][x]) {
                            seen[i][j][x ^ grid[i][j]] = true;
                        }
                    }
                }
            }
        }

        for (int x = 0; x < 1024; x++) {
            if (seen[m - 1][n - 1][x]) {
                return x;
            }
        }

        return 0;
    }
}

