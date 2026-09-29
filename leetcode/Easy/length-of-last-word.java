// Problem: Length of Last Word
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/length-of-last-word/
// Solved on: 2026-09-29T17:19:16.655Z

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }

        return count;
    }
}