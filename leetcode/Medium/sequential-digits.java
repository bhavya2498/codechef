// Problem: Sequential Digits
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/sequential-digits/
// Solved on: 2026-11-03T07:44:25.480Z


import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        String digits = "123456789";

        for (int length = 2; length <= 9; length++) {
            for (int start = 0; start + length <= 9; start++) {

                String number = digits.substring(start, start + length);
                int num = Integer.parseInt(number);

                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
