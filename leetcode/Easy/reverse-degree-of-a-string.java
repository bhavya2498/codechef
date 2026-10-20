// Problem: Reverse Degree of a String
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/reverse-degree-of-a-string/
// Solved on: 2026-10-20T06:19:51.016Z

class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int reversePosition = 'z' - s.charAt(i) + 1;
            sum += reversePosition * (i + 1);
        }

        return sum;
    }
}