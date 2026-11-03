// Problem: Matchsticks to Square
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/4sum-ii/
// Solved on: 2026-11-03T17:44:36.973Z


import java.util.*;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2,
                            int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Store all sums of nums1 and nums2
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // Step 2: Find complementary sums from nums3 and nums4
        int count = 0;

        for (int c : nums3) {
            for (int d : nums4) {
                int sum = c + d;
                int target = -sum;

                count += map.getOrDefault(target, 0);
            }
        }

        return count;
    }
}
