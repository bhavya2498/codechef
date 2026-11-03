// Problem: Matchsticks to Square
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/matchsticks-to-square/
// Solved on: 2026-11-03T17:45:11.898Z


import java.util.*;

class Solution {
    public boolean makesquare(int[] matchsticks) {

        int total = 0;

        for (int stick : matchsticks) {
            total += stick;
        }

        // Total must be divisible by 4
        if (total % 4 != 0) {
            return false;
        }

        int target = total / 4;

        // Sort in descending order
        Integer[] sticks = new Integer[matchsticks.length];

        for (int i = 0; i < matchsticks.length; i++) {
            sticks[i] = matchsticks[i];
        }

        Arrays.sort(sticks, Collections.reverseOrder());

        // Largest stick cannot exceed one side
        if (sticks[0] > target) {
            return false;
        }

        int[] sides = new int[4];

        return backtrack(sticks, sides, 0, target);
    }

    private boolean backtrack(Integer[] sticks, int[] sides,
                              int index, int target) {

        // All matchsticks have been placed
        if (index == sticks.length) {
            return true;
        }

        int current = sticks[index];

        for (int i = 0; i < 4; i++) {

            // Do not exceed the target
            if (sides[i] + current <= target) {

                sides[i] += current;

                if (backtrack(sticks, sides, index + 1, target)) {
                    return true;
                }

                // Backtrack
                sides[i] -= current;
            }

            // Avoid trying identical empty sides
            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }
}
