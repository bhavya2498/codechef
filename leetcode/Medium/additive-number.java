// Problem: Additive Number
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/additive-number/
// Solved on: 2026-11-03T15:57:23.208Z


import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {

            // First number cannot have leading zeros
            if (num.charAt(0) == '0' && i > 1) {
                break;
            }

            BigInteger first =
                new BigInteger(num.substring(0, i));

            for (int j = i + 1;
                 j < n; j++) {

                // Second number cannot have leading zeros
                if (num.charAt(i) == '0' && j - i > 1) {
                    break;
                }

                BigInteger second =
                    new BigInteger(num.substring(i, j));

                if (check(num, j, first, second)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(String num, int index,
                          BigInteger first,
                          BigInteger second) {

        if (index == num.length()) {
            return true;
        }

        BigInteger sum = first.add(second);
        String sumStr = sum.toString();

        if (!num.startsWith(sumStr, index)) {
            return false;
        }

        return check(num,
                     index + sumStr.length(),
                     second,
                     sum);
    }
}
