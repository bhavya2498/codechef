// Problem: Different Ways to Add Parentheses
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/different-ways-to-add-parentheses/
// Solved on: 2026-10-06T14:33:40.246Z

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char op = expression.charAt(i);

            if (op == '+' || op == '-' || op == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for (int a : left) {
                    for (int b : right) {
                        if (op == '+') result.add(a + b);
                        else if (op == '-') result.add(a - b);
                        else result.add(a * b);
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
}