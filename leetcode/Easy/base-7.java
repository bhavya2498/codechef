// Problem: Base 7
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/base-7/
// Solved on: 2026-11-01T07:58:05.528Z


class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";

        boolean negative = num < 0;
        num = Math.abs(num);

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int remainder = num % 7;
            sb.append(remainder);
            num /= 7;
        }

        if (negative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}
