// Problem: Find Greatest Common Divisor of Array
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-greatest-common-divisor-of-array/
// Solved on: 2026-11-03T04:44:04.706Z


class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int num : nums) {
            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }

        // Find GCD using Euclidean Algorithm
        while (max % min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }

        return min;
    }
}
