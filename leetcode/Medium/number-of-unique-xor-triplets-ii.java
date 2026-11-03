// Problem: Number of Unique XOR Triplets II
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/number-of-unique-xor-triplets-ii/
// Solved on: 2026-11-03T04:42:34.569Z


class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int limit = 2048;

        boolean[] one = new boolean[limit];
        boolean[] two = new boolean[limit];
        boolean[] three = new boolean[limit];

        for (int num : nums) {
            one[num] = true;
        }

        for (int i = 0; i < limit; i++) {
            if (one[i]) {
                for (int j = 0; j < limit; j++) {
                    if (one[j]) {
                        two[i ^ j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < limit; i++) {
            if (two[i]) {
                for (int j = 0; j < limit; j++) {
                    if (one[j]) {
                        three[i ^ j] = true;
                    }
                }
            }
        }

        int count = 0;

        for (boolean possible : three) {
            if (possible) {
                count++;
            }
        }

        return count;
    }
}
