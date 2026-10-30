// Problem: First Unique Character in a String
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/first-unique-character-in-a-string/
// Solved on: 2026-10-30T17:20:30.787Z


class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];

        // First pass: Count frequency of each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Second pass: Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
