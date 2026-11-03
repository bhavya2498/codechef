// Problem: Longest Subsequence With Non-Zero Bitwise XOR
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/
// Solved on: 2026-11-03T03:49:38.490Z


class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                hasNonZero = true;
            }
        }

        if (xor != 0) {
            return nums.length;
        }

        if (!hasNonZero) {
            return 0;
        }

        return nums.length - 1;
    }
}
