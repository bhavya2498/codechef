// Problem: Find the Lexicographically Smallest Valid Sequence
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/
// Solved on: 2026-11-03T03:52:16.673Z


class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // suffix[i] = number of matching characters
        // when matching word2 from right to left
        int[] suffix = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suffix[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;
        int mismatches = 0;

        while (j < m && i < n) {

            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } 
            else if (mismatches == 0 &&
                     suffix[i + 1] >= m - j - 1) {

                // Use our one allowed mismatch
                ans[j] = i;
                j++;
                mismatches++;
            }

            i++;
        }

        if (j == m) {
            return ans;
        }

        return new int[0];
    }
}
