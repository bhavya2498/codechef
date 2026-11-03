// Problem: Shift 2D Grid
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/shift-2d-grid/
// Solved on: 2026-11-03T04:43:44.652Z


import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int total = m * n;
        k = k % total;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int oldIndex = (i * n + j - k + total) % total;

                int oldRow = oldIndex / n;
                int oldCol = oldIndex % n;

                row.add(grid[oldRow][oldCol]);
            }

            result.add(row);
        }

        return result;
    }
}
