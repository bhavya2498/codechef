// Problem: Nth Digit
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/nth-digit/
// Solved on: 2026-11-03T17:31:41.906Z


class Solution {
    public int findNthDigit(int n) {

        long digitLength = 1;
        long count = 9;
        long start = 1;

        // Find the group containing the nth digit
        while (n > digitLength * count) {

            n -= digitLength * count;

            digitLength++;
            count *= 10;
            start *= 10;
        }

        // Find the exact number
        long offset = n - 1;

        long number = start + offset / digitLength;

        // Find the digit's position inside that number
        int digitIndex = (int)(offset % digitLength);

        String s = String.valueOf(number);

        return s.charAt(digitIndex) - '0';
    }
}
