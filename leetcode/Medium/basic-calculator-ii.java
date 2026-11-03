// Problem: Basic Calculator II
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/basic-calculator-ii/
// Solved on: 2026-11-03T15:41:52.669Z


import java.util.*;

class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Build the complete number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // Process when we reach an operator
            // or the last character
            if ((!Character.isDigit(ch) && ch != ' ') ||
                i == s.length() - 1) {

                if (operator == '+') {
                    stack.push(num);
                }
                else if (operator == '-') {
                    stack.push(-num);
                }
                else if (operator == '*') {
                    stack.push(stack.pop() * num);
                }
                else if (operator == '/') {
                    stack.push(stack.pop() / num);
                }

                operator = ch;
                num = 0;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
