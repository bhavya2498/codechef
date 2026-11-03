// Problem: Longest Word in Dictionary through Deleting
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
// Solved on: 2026-11-03T17:51:22.100Z


import java.util.*;

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {

        String result = "";

        for (String word : dictionary) {

            if (isSubsequence(s, word)) {

                if (word.length() > result.length() ||
                    (word.length() == result.length() &&
                     word.compareTo(result) < 0)) {

                    result = word;
                }
            }
        }

        return result;
    }

    private boolean isSubsequence(String s, String word) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < word.length()) {

            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }

            i++;
        }

        return j == word.length();
    }
}
