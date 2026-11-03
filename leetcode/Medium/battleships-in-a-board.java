// Problem: Battleships in a Board
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/battleships-in-a-board/
// Solved on: 2026-11-03T17:36:02.027Z


class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 'X') {

                    if ((i == 0 || board[i - 1][j] != 'X') &&
                        (j == 0 || board[i][j - 1] != 'X')) {

                        count++;
                    }
                }
            }
        }

        return count;
    }
}
