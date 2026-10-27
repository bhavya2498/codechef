// Problem: Create Grid With Exactly One Path
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/create-grid-with-exactly-one-path/
// Solved on: 2026-10-27T04:41:38.895Z


class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        for (int i = 0; i < m; i++) {
            char[] row = new char[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    row[j] = '.';
                } else {
                    row[j] = '#';
                }
            }

            grid[i] = new String(row);
        }

        return grid;
    }
}
