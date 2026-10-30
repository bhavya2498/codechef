// Problem: Third Maximum Number
// Platform: leetcode
// Rating/Difficulty: Unrated
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/third-maximum-number/
// Solved on: 2026-10-30T17:23:46.551Z


class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {

            // Ignore duplicates
            if (num == first || num == second || num == third) {
                continue;
            }

            if (num > first) {
                third = second;
                second = first;
                first = num;
            }
            else if (num > second) {
                third = second;
                second = num;
            }
            else if (num > third) {
                third = num;
            }
        }

        // Return third maximum if it exists
        if (third == Long.MIN_VALUE) {
            return (int) first;
        }

        return (int) third;
    }
}
