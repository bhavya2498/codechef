// Problem: Minimum Moves to Equal Array Elements III
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/
// Solved on: 2026-11-03T03:33:37.476Z


class Solution {
    public int minMoves(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int moves = 0;

        for (int num : nums) {
            moves += max - num;
        }

        return moves;
    }
}
