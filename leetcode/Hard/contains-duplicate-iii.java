// Problem: Contains Duplicate III
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/contains-duplicate-iii/
// Solved on: 2026-09-28T14:02:17.234Z

import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            long x = nums[i];

            Long small = set.floor(x);

            if (small != null && x - small <= valueDiff) {
                return true;
            }

            Long large = set.ceiling(x);

            if (large != null && large - x <= valueDiff) {
                return true;
            }

            set.add(x);

            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}