// Problem: Maximum K to Sort a Permutation
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/maximum-k-to-sort-a-permutation/
// Solved on: 2026-10-23T15:56:55.854Z


class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                k &= nums[i];
            }
        }

        return k == -1 ? 0 : k;
    }
}
