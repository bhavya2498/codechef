// Problem: Twisted Mirror Path Count
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/twisted-mirror-path-count/
// Solved on: 2026-11-01T14:49:41.854Z


class Solution {
    static final int MOD = 1_000_000_007;

    int m, n;
    int[][][] memo;

    // dir = 0 means right, dir = 1 means down
    int resolve(int r, int c, int dir, int[][] grid) {

        if (r >= m || c >= n) {
            return -1;
        }

        // Reached an empty cell
        if (grid[r][c] == 0) {
            return r * n + c;
        }

        // Already calculated
        if (memo[r][c][dir] != -2) {
            return memo[r][c][dir];
        }

        // Mirror redirects the robot
        if (dir == 0) {
            memo[r][c][dir] =
                resolve(r + 1, c, 1, grid);
        } else {
            memo[r][c][dir] =
                resolve(r, c + 1, 0, grid);
        }

        return memo[r][c][dir];
    }

    public int uniquePaths(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j][0] = -2;
                memo[i][j][1] = -2;
            }
        }

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0) {
                    continue;
                }

                // Try moving right
                int right = resolve(i, j + 1, 0, grid);

                if (right != -1) {
                    int x = right / n;
                    int y = right % n;

                    dp[x][y] = (dp[x][y] + dp[i][j]) % MOD;
                }

                // Try moving down
                int down = resolve(i + 1, j, 1, grid);

                if (down != -1) {
                    int x = down / n;
                    int y = down % n;

                    dp[x][y] = (dp[x][y] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}
