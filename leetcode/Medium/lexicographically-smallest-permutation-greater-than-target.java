// Problem: Lexicographically Smallest Permutation Greater Than Target
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/
// Solved on: 2026-11-03T03:45:28.606Z


class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        // Try to match target from left to right
        for (int i = 0; i < n; i++) {

            int ch = target.charAt(i) - 'a';

            // Try to use the same character
            if (freq[ch] > 0) {
                freq[ch]--;
                result.append(target.charAt(i));
                continue;
            }

            // Same character is unavailable.
            // Try the smallest available character greater than it.
            for (int j = ch + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    freq[j]--;

                    result.append((char) ('a' + j));

                    // Add all remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            result.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return result.toString();
                }
            }

            // Cannot match this position or make it greater.
            // Backtrack to an earlier position.
            for (int k = i - 1; k >= 0; k--) {
                int previous = result.charAt(k) - 'a';
                freq[previous]++;

                result.setLength(k);

                for (int j = previous + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        freq[j]--;

                        result.append((char) ('a' + j));

                        for (int x = 0; x < 26; x++) {
                            while (freq[x] > 0) {
                                result.append((char) ('a' + x));
                                freq[x]--;
                            }
                        }

                        return result.toString();
                    }
                }
            }

            return "";
        }

        // Entire target matched exactly.
        // Backtrack to find the next greater permutation.
        for (int i = n - 1; i >= 0; i--) {
            int previous = result.charAt(i) - 'a';
            freq[previous]++;

            result.setLength(i);

            for (int j = previous + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    freq[j]--;

                    result.append((char) ('a' + j));

                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            result.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return result.toString();
                }
            }
        }

        return "";
    }
}
