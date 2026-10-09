// Problem: Minimum Insertions to Balance a Parentheses String
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
// Solved on: 2026-10-09T15:02:56.352Z


class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                open++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (open > 0) {
                        open--;
                    } else {
                        insertions++;
                    }
                    i++;
                } else {
                    if (open > 0) {
                        open--;
                        insertions++;
                    } else {
                        insertions += 2;
                    }
                }
            }
        }

        return insertions + open * 2;
    }
}
