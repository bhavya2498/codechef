// Problem: Happy Number
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/happy-number/
// Solved on: 2026-10-30T17:08:29.389Z


import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {

            // If number repeats, a cycle exists
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);

            int sum = 0;

            // Calculate sum of squares of digits
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        return true;
    }
}
