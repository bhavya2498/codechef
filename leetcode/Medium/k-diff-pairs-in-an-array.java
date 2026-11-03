// Problem: K-diff Pairs in an Array
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/k-diff-pairs-in-an-array/
// Solved on: 2026-11-03T17:54:15.903Z


import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {

        if (k < 0) return 0;

        Set<Integer> seen = new HashSet<>();
        Set<Integer> pairs = new HashSet<>();

        for (int num : nums) {

            if (seen.contains(num - k)) {
                pairs.add(num);
            }

            if (seen.contains(num + k)) {
                pairs.add(num + k);
            }

            seen.add(num);
        }

        return pairs.size();
    }
}
