// Problem: Power of Four
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/power-of-four/
// Solved on: 2026-10-30T17:18:12.322Z


class Solution {
    public boolean isPowerOfFour(int n) {

        return n > 0
            && (n & (n - 1)) == 0
            && (n & 0x55555555) != 0;
    }
}
