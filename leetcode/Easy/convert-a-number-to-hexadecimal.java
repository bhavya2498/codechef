// Problem: Convert a Number to Hexadecimal
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/convert-a-number-to-hexadecimal/
// Solved on: 2026-10-06T14:31:03.157Z

class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder result = new StringBuilder();

        while (num != 0) {
            result.append(hex[num & 15]);
            num >>>= 4;
        }

        return result.reverse().toString();
    }
}