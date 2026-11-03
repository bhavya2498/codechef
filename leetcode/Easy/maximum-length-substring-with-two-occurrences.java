// Problem: Maximum Length Substring With Two Occurrences
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/
// Solved on: 2026-11-03T03:50:17.360Z


class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            freq[ch - 'a']++;

            while (freq[ch - 'a'] > 2) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                left++;
            }

            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
