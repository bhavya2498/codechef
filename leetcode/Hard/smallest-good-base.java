// Problem: Smallest Good Base
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/smallest-good-base/
// Solved on: 2026-11-01T07:50:39.223Z


class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        // Maximum possible number of digits is 60
        for (int m = 60; m >= 2; m--) {

            long left = 2;
            long right = (long) Math.pow(num, 1.0 / (m - 1)) + 1;

            while (left <= right) {
                long k = left + (right - left) / 2;

                long sum = 1;
                long term = 1;

                for (int i = 1; i < m; i++) {
                    if (term > (num - 1) / k) {
                        sum = num + 1;
                        break;
                    }

                    term *= k;
                    sum += term;

                    if (sum > num) break;
                }

                if (sum == num) {
                    return String.valueOf(k);
                } else if (sum < num) {
                    left = k + 1;
                } else {
                    right = k - 1;
                }
            }
        }

        // Every number has a 2-digit representation of all ones
        return String.valueOf(num - 1);
    }
}
