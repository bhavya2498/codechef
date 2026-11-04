// Problem: Elimination Game
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/elimination-game/
// Solved on: 2026-11-04T04:46:27.186Z


class Solution {
    public int lastRemaining(int n) {

        int head = 1;
        int step = 1;
        int remaining = n;
        boolean left = true;

        while (remaining > 1) {

            if (left || remaining % 2 == 1) {
                head = head + step;
            }

            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }

        return head;
    }
}
