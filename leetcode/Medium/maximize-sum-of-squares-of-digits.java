// Problem: Maximize Sum of Squares of Digits
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/maximize-sum-of-squares-of-digits/
// Solved on: 2026-11-01T14:52:03.328Z


class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // Check whether a valid number is possible
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);

            ans.append(digit);
            sum -= digit;
        }

        return ans.toString();
    }
}
