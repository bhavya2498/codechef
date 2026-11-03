// Problem: Complex Number Multiplication
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/complex-number-multiplication/
// Solved on: 2026-11-03T17:55:37.996Z


class Solution {
    public String complexNumberMultiply(String num1, String num2) {

        String[] a = num1.split("\\+|i");
        String[] b = num2.split("\\+|i");

        int real1 = Integer.parseInt(a[0]);
        int imag1 = Integer.parseInt(a[1]);

        int real2 = Integer.parseInt(b[0]);
        int imag2 = Integer.parseInt(b[1]);

        int real = real1 * real2 - imag1 * imag2;

        int imaginary = real1 * imag2 + imag1 * real2;

        return real + "+" + imaginary + "i";
    }
}
