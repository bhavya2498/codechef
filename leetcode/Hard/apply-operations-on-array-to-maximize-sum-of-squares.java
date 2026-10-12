// Problem: Apply Operations on Array to Maximize Sum of Squares
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/
// Solved on: 2026-10-12T13:05:20.124Z


import java.util.*;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007L;
        int[] bitCount = new int[31];

        // Count how many numbers contain each bit
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }

        long ans = 0;

        // Construct the maximum possible number k times
        for (int i = 0; i < k; i++) {
            long value = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    value |= (1L << bit);
                    bitCount[bit]--;
                }
            }

            ans = (ans + value * value) % MOD;
        }

        return (int) ans;
    }
}
