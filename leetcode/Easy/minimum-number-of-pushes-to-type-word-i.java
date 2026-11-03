// Problem: Minimum Number of Pushes to Type Word I
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
// Solved on: 2026-11-03T03:54:28.623Z


class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;

        for (int i = 0; i < n; i++) {
            pushes += (i / 8) + 1;
        }

        return pushes;
    }
}
