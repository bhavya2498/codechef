// Problem: Find the Difference
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-the-difference/
// Solved on: 2026-10-06T14:29:51.500Z

class Solution {
    public char findTheDifference(String s, String t) {
        int result = 0;

        for (char c : s.toCharArray()) {
            result ^= c;
        }

        for (char c : t.toCharArray()) {
            result ^= c;
        }

        return (char) result;
    }
}