// Problem: Factorial Trailing Zeroes
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/factorial-trailing-zeroes/
// Solved on: 2026-10-30T16:55:24.639Z

class Solution {
    public int trailingZeroes(int n) {

        int count = 0;

        while (n > 0) {
            n = n / 5;
            count += n;
        }

        return count;
    }
}