// Problem: Find Missing Elements
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-missing-elements/
// Solved on: 2026-11-03T03:53:14.555Z


import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        int min = nums[0];
        int max = nums[0];

        // Find minimum, maximum and store elements
        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Check every number in the range
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
