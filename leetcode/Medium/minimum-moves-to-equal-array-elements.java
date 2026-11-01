// Problem: Minimum Moves to Equal Array Elements
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
// Solved on: 2026-11-01T14:48:55.528Z


class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        
        int moves = 0;
        
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }
        
        return moves;
    }
}
