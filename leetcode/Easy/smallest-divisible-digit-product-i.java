// Problem: Smallest Divisible Digit Product I
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/smallest-divisible-digit-product-i/
// Solved on: 2026-11-03T03:52:48.666Z


class Solution {
    public int smallestNumber(int n, int t) {

        while (true) {
            int temp = n;
            int product = 1;

            // Calculate product of digits
            while (temp > 0) {
                int digit = temp % 10;
                product *= digit;
                temp /= 10;
            }

            // Check divisibility
            if (product % t == 0) {
                return n;
            }

            n++;
        }
    }
}
