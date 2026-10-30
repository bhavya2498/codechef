// Problem: Ransom Note
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/ransom-note/
// Solved on: 2026-10-30T17:20:02.446Z


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        // Count characters in magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Use characters to construct ransomNote
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;

            // Character is not available
            if (count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
