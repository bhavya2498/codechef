// Problem: Bitwise AND of Numbers Range
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/bitwise-and-of-numbers-range/
// Solved on: 2026-10-30T17:09:06.380Z


class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        int shifts = 0;

        // Find the common leading bits
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shifts++;
        }

        // Restore the common bits to their original positions
        return left << shifts;
    }
}
