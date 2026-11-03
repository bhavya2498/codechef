// Problem: Smallest Missing Multiple of K
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/smallest-missing-multiple-of-k/
// Solved on: 2026-11-03T03:46:26.680Z


import java.util.*;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        // Store all array elements
        for (int num : nums) {
            set.add(num);
        }

        // Check multiples of k
        int multiple = k;

        while (set.contains(multiple)) {
            multiple += k;
        }

        return multiple;
    }
}
