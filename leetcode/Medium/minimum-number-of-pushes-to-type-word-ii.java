// Problem: Minimum Number of Pushes to Type Word II
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
// Solved on: 2026-11-03T03:55:09.729Z


import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort frequencies in ascending order
        Arrays.sort(freq);

        int total = 0;

        // Process from highest frequency to lowest
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                break;
            }

            int pushes = ((25 - i) / 8) + 1;
            total += freq[i] * pushes;
        }

        return total;
    }
}
