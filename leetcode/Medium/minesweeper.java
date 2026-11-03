// Problem: Minesweeper
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minesweeper/
// Solved on: 2026-11-03T17:53:42.278Z


class Solution {

    int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click) {

        int r = click[0];
        int c = click[1];

        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        dfs(board, r, c);

        return board;
    }

    private void dfs(char[][] board, int r, int c) {

        int m = board.length;
        int n = board[0].length;

        int mines = 0;

        // Count adjacent mines
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                board[nr][nc] == 'M') {
                mines++;
            }
        }

        // If adjacent mines exist, show the count
        if (mines > 0) {
            board[r][c] = (char) ('0' + mines);
            return;
        }

        // Otherwise, reveal as blank
        board[r][c] = 'B';

        // Explore all 8 neighboring cells
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                board[nr][nc] == 'E') {

                dfs(board, nr, nc);
            }
        }
    }
}
