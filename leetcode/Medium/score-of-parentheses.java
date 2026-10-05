// Problem: Score of Parentheses
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/score-of-parentheses/
// Solved on: 2026-10-05T12:45:55.493Z

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int x = stack.pop();
                int score = (x == 0) ? 1 : 2 * x;

                int parent = stack.pop();
                stack.push(parent + score);
            }
        }

        return stack.pop();
    }
}