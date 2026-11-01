// Problem: Number Complement
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/number-complement/
// Solved on: 2026-11-01T07:28:31.243Z


class Solution {
    public int findComplement(int num) {
        int mask = 1;

        while (mask < num) {
            mask = (mask << 1) | 1;
        }

        return num ^ mask;
    }
}
