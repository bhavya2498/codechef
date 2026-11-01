// Problem: Remove Outermost Parentheses
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/remove-outermost-parentheses/
// Solved on: 2026-11-01T14:52:31.204Z


class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (depth > 0) {
                    result.append(ch);
                }
                depth++;
            } else {
                depth--;

                if (depth > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
