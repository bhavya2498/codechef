// Problem: Smallest Palindromic Rearrangement I
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
// Solved on: 2026-11-03T03:55:40.514Z


class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        // Build the left half in alphabetical order
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                middle.append((char) (i + 'a'));
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) (i + 'a'));
            }
        }

        // Right half is the reverse of left half
        String right = left.reverse().toString();

        return left.reverse().toString()
                + middle.toString()
                + right;
    }
}
