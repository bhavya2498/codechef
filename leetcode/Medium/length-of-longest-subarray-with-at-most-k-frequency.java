// Problem: Length of Longest Subarray With at Most K Frequency
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/
// Solved on: 2026-11-03T03:50:48.505Z


import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            int num = nums[right];

            map.put(num, map.getOrDefault(num, 0) + 1);

            while (map.get(num) > k) {
                int leftNum = nums[left];

                map.put(leftNum, map.get(leftNum) - 1);

                left++;
            }

            int length = right - left + 1;

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
