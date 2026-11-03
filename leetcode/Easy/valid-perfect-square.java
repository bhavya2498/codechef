// Problem: Valid Perfect Square
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/valid-perfect-square/
// Solved on: 2026-11-03T17:17:48.595Z


class Solution {
    public boolean isPerfectSquare(int num) {

        long left = 1;
        long right = num;

        while (left <= right) {

            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            }
            else if (square < num) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }
}
