// Problem: Maximum Alternating Sum of Squares
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/maximum-alternating-sum-of-squares/
// Solved on: 2026-10-13T12:58:22.870Z


class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] squares = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        java.util.Arrays.sort(squares);

        long sum = 0;
        int n = squares.length;

        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                sum -= squares[i];
            } else {
                sum += squares[i];
            }
        }

        return sum;
    }
}
