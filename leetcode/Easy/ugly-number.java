// Problem: Ugly Number
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/ugly-number/
// Solved on: 2026-10-30T17:05:52.276Z


class Solution {
    public boolean isUgly(int n) {

        // Ugly numbers must be positive
        if (n <= 0) {
            return false;
        }

        // Remove all factors of 2
        while (n % 2 == 0) {
            n /= 2;
        }

        // Remove all factors of 3
        while (n % 3 == 0) {
            n /= 3;
        }

        // Remove all factors of 5
        while (n % 5 == 0) {
            n /= 5;
        }

        // If nothing except factors 2, 3, 5 remains
        return n == 1;
    }
}
