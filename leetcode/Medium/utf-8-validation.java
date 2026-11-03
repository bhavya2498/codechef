// Problem: UTF-8 Validation
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/utf-8-validation/
// Solved on: 2026-11-03T17:26:31.943Z


class Solution {
    public boolean validUtf8(int[] data) {

        int remaining = 0;

        for (int num : data) {

            if (remaining == 0) {

                if ((num >> 7) == 0) {
                    remaining = 0;
                }
                else if ((num >> 5) == 0b110) {
                    remaining = 1;
                }
                else if ((num >> 4) == 0b1110) {
                    remaining = 2;
                }
                else if ((num >> 3) == 0b11110) {
                    remaining = 3;
                }
                else {
                    return false;
                }

            } else {

                if ((num >> 6) != 0b10) {
                    return false;
                }

                remaining--;
            }
        }

        return remaining == 0;
    }
}
