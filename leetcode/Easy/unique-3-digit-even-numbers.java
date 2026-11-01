// Problem: Unique 3-Digit Even Numbers
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/unique-3-digit-even-numbers/
// Solved on: 2026-11-01T14:58:41.364Z


import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {

                    // Cannot reuse the same index
                    if (i == j || j == k || i == k) {
                        continue;
                    }

                    // No leading zero
                    if (digits[i] == 0) {
                        continue;
                    }

                    // Last digit must be even
                    if (digits[k] % 2 != 0) {
                        continue;
                    }

                    int num = digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    set.add(num);
                }
            }
        }

        return set.size();
    }
}
