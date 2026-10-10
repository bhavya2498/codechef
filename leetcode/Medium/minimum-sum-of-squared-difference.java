// Problem: Minimum Sum of Squared Difference
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-sum-of-squared-difference/
// Solved on: 2026-10-10T17:01:35.497Z

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long[] freq = new long[100001];
        long k = (long) k1 + k2;

        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
        }

        for (int d = 100000; d > 0 && k > 0; d--) {
            long moves = Math.min(k, freq[d]);

            freq[d] -= moves;
            freq[d - 1] += moves;
            k -= moves;
        }

        long ans = 0;

        for (int d = 1; d <= 100000; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}