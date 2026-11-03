// Problem: Contiguous Array
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/contiguous-array/
// Solved on: 2026-11-03T17:52:02.669Z


import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {

                int length = i - map.get(sum);

                maxLength = Math.max(maxLength, length);

            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
