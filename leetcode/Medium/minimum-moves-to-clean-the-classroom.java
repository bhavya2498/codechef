// Problem: Minimum Moves to Clean the Classroom
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/
// Solved on: 2026-11-01T15:19:49.320Z


import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int startR = 0, startC = 0;
        int litterCount = 0;

        // Find starting position and assign IDs to litter.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int targetMask = (1 << litterCount) - 1;

        if (litterCount == 0) return 0;

        boolean[][][] visited =
            new boolean[m * n][1 << litterCount][energy + 1];

        // State: row, column, mask, remaining energy
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startR, startC, 0, energy});
        visited[startR * n + startC][0][energy] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int rem = curr[3];

                if (mask == targetMask) {
                    return moves;
                }

                // Cannot move with zero energy.
                if (rem == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    char ch = classroom[nr].charAt(nc);

                    if (ch == 'X') continue;

                    int newMask = mask;

                    // Collect litter.
                    if (ch == 'L') {
                        newMask |= (1 << litterId[nr][nc]);
                    }

                    // Spend one energy unit.
                    int newEnergy = rem - 1;

                    // Reset energy when entering R.
                    if (ch == 'R') {
                        newEnergy = energy;
                    }

                    if (newMask == targetMask) {
                        return moves + 1;
                    }

                    int pos = nr * n + nc;

                    if (!visited[pos][newMask][newEnergy]) {
                        visited[pos][newMask][newEnergy] = true;

                        queue.offer(new int[]{
                            nr, nc, newMask, newEnergy
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}
