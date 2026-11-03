// Problem: Integer Replacement
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/integer-replacement/
// Solved on: 2026-11-03T17:28:52.608Z


class Solution {
    public int integerReplacement(int n) {

        long num = n;
        int count = 0;

        while (num != 1) {

            if (num % 2 == 0) {
                num = num / 2;
            }
            else if (num == 3 || num % 4 == 1) {
                num = num - 1;
            }
            else {
                num = num + 1;
            }

            count++;
        }

        return count;
    }
}
