// Problem: Water and Jug Problem
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/water-and-jug-problem/
// Solved on: 2026-11-03T16:08:56.801Z


class Solution {
    public boolean canMeasureWater(int x, int y, int target) {

        if (target == 0) {
            return true;
        }

        if (target > x + y) {
            return false;
        }

        return target % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
