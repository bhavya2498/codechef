// Problem: Check Divisibility by Digit Sum and Product
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/
// Solved on: 2026-11-03T03:47:24.654Z


class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int product = 1;

        while (temp > 0) {
            int digit = temp % 10;

            sum += digit;
            product *= digit;

            temp /= 10;
        }

        int total = sum + product;

        return n % total == 0;
    }
}
