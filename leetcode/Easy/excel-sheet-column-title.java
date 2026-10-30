// Problem: Excel Sheet Column Title
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/excel-sheet-column-title/
// Solved on: 2026-10-30T16:54:35.837Z

class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {

            columnNumber--;

            int remainder = columnNumber % 26;

            char ch = (char) ('A' + remainder);

            result.append(ch);

            columnNumber = columnNumber / 26;
        }

        return result.reverse().toString();
    }
}