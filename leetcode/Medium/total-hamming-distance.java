// Problem: Total Hamming Distance
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/total-hamming-distance/
// Solved on: 2026-11-01T07:29:11.146Z


class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;

        for (int bit = 0; bit < 32; bit++) {
            int ones = 0;

            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    ones++;
                }
            }

            int zeros = n - ones;
            total += ones * zeros;
        }

        return total;
    }
}
