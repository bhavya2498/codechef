// Problem: Generate Parentheses
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/generate-parentheses/
// Solved on: 2026-09-23T14:10:41.536Z

class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    private void backtrack(List<String> result, String current,
        int open, int close, int n) {
        if (open == n && close == n) {
            result.add(current);
            return;
        }
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}