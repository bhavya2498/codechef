// Problem: Remove K Digits
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/remove-k-digits/
// Solved on: 2026-11-03T17:32:44.408Z


class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {

            while (k > 0 && stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > digit) {

                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(digit);
        }

        // Remove remaining digits from the end
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        int index = 0;
        while (index < stack.length() && stack.charAt(index) == '0') {
            index++;
        }

        String result = stack.substring(index);

        return result.isEmpty() ? "0" : result;
    }
}
