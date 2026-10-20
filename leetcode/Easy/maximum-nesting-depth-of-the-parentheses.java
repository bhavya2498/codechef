// Problem: Maximum Nesting Depth of the Parentheses
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
// Solved on: 2026-10-20T06:19:01.014Z

class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == ')') {
                depth--;
            }
        }

        return maxDepth;
    }
}