// Problem: Smallest Index With Digit Sum Equal to Index
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/
// Solved on: 2026-11-01T14:53:39.304Z


class Solution {
    public int smallestIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = 0;

            // Calculate digit sum
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }
}
