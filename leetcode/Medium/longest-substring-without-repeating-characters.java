// Problem: Longest Substring Without Repeating Characters
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Solved on: 2026-10-03T17:37:42.234Z

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}