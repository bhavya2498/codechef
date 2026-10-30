// Problem: Summary Ranges
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/summary-ranges/
// Solved on: 2026-10-30T17:02:50.092Z


import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < nums.length) {
            int start = nums[i];

            // Find the end of the consecutive range
            while (i + 1 < nums.length &&
                   (long) nums[i + 1] - nums[i] == 1) {
                i++;
            }

            int end = nums[i];

            // Format the range
            if (start == end) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + end);
            }

            i++;
        }

        return result;
    }
}
