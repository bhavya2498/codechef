// Problem: Longest Substring with At Least K Repeating Characters
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
// Solved on: 2026-11-03T17:27:41.267Z


class Solution {

    public int longestSubstring(String s, int k) {

        if (s.length() < k) {
            return 0;
        }

        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Find a character occurring fewer than k times
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (freq[ch - 'a'] < k) {

                // Split the string using this character
                String[] parts = s.split(String.valueOf(ch));

                int maxLength = 0;

                // Recursively solve each part
                for (String part : parts) {
                    maxLength = Math.max(
                        maxLength,
                        longestSubstring(part, k)
                    );
                }

                return maxLength;
            }
        }

        // Every character occurs at least k times
        return s.length();
    }
}
