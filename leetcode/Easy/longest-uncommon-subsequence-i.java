// Problem: Longest Uncommon Subsequence I
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/longest-uncommon-subsequence-i/
// Solved on: 2026-11-01T08:01:13.671Z

class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }

        return Math.max(a.length(), b.length());
    }
}