// Problem: Is Subsequence
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/is-subsequence/
// Solved on: 2026-10-06T14:30:27.909Z

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;

        for (int j = 0; j < t.length(); j++) {
            if (i < s.length() && s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == s.length();
    }
}