// Problem: Smallest Stable Index I
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/smallest-stable-index-i/
// Solved on: 2026-11-01T15:02:55.333Z


class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int max = nums[0];
            int min = nums[i];

            // Find maximum from index 0 to i
            for (int j = 0; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }

            // Find minimum from index i to n-1
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
            }

            if (max - min <= k) {
                return i;
            }
        }

        return -1;
    }
}
