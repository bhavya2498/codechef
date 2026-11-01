// Problem: Hamming Distance
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/hamming-distance/
// Solved on: 2026-11-01T07:22:29.242Z


class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        while (xor != 0) {
            count += xor & 1;
            xor >>= 1;
        }

        return count;
    }
}
