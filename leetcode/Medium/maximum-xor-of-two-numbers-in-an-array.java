// Problem: Maximum XOR of Two Numbers in an Array
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
// Solved on: 2026-11-01T06:18:35.404Z


import java.util.*;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXor = 0;
        int mask = 0;

        for (int bit = 30; bit >= 0; bit--) {

            // Include the current bit
            mask |= (1 << bit);

            Set<Integer> prefixes = new HashSet<>();

            // Store prefixes of all numbers
            for (int num : nums) {
                prefixes.add(num & mask);
            }

            // Try setting the current bit to 1
            int candidate = maxXor | (1 << bit);

            // Check whether two prefixes produce candidate
            for (int prefix : prefixes) {
                int required = prefix ^ candidate;

                if (prefixes.contains(required)) {
                    maxXor = candidate;
                    break;
                }
            }
        }

        return maxXor;
    }
}
