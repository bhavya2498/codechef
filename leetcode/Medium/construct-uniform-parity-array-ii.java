// Problem: Construct Uniform Parity Array II
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/construct-uniform-parity-array-ii/
// Solved on: 2026-11-03T03:35:32.642Z


class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean hasOdd = false;
        boolean hasEven = false;

        for (int num : nums1) {
            min = Math.min(min, num);

            if (num % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }
        }

        if (!hasOdd || !hasEven) {
            return true;
        }

        return min % 2 != 0;
    }
}
