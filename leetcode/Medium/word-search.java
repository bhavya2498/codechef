// Problem: Word Search
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/word-search/
// Solved on: 2026-10-30T04:09:10.354Z


class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int i, int j, int index) {

        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and character match
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length ||
            board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore four directions
        boolean found =
            dfs(board, word, i + 1, j, index + 1) ||
            dfs(board, word, i - 1, j, index + 1) ||
            dfs(board, word, i, j + 1, index + 1) ||
            dfs(board, word, i, j - 1, index + 1);

        // Backtracking: restore original character
        board[i][j] = temp;

        return found;
    }
}
