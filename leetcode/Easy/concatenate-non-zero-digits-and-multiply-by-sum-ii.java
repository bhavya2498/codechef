// Problem: Concatenate Non-Zero Digits and Multiply by Sum I
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/
// Solved on: 2026-11-03T07:48:02.290Z


class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int MOD = 1_000_000_007;
        int n = s.length();

        long[] prefixNumber = new long[n + 1];
        long[] prefixSum = new long[n + 1];
        int[] prefixCount = new int[n + 1];

        long[] power10 = new long[n + 1];
        power10[0] = 1;

        for (int i = 1; i <= n; i++) {
            power10[i] = (power10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';

            prefixNumber[i + 1] = prefixNumber[i];
            prefixSum[i + 1] = prefixSum[i];
            prefixCount[i + 1] = prefixCount[i];

            if (digit != 0) {
                prefixNumber[i + 1] =
                    (prefixNumber[i] * 10 + digit) % MOD;

                prefixSum[i + 1] += digit;
                prefixCount[i + 1]++;
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            long sum = prefixSum[r + 1] - prefixSum[l];

            int count = prefixCount[r + 1] - prefixCount[l];

            long x = (
                prefixNumber[r + 1]
                - prefixNumber[l] * power10[count] % MOD
                + MOD
            ) % MOD;

            answer[i] = (int) (x * sum % MOD);
        }

        return answer;
    }
}
