// Problem: Excel Sheet Column Number
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/excel-sheet-column-number/
// Solved on: 2026-09-29T17:24:03.689Z

class Solution {
    public int titleToNumber(String columnTitle) {

        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {

            int value = columnTitle.charAt(i) - 'A' + 1;

            result = result * 26 + value;
        }

        return result;
    }
}