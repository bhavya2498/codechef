// Problem: Single Element in a Sorted Array
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/single-element-in-a-sorted-array/
// Solved on: 2026-11-03T17:57:13.923Z


class Solution {
    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            // Pair is correct
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }

            // Single element is on the left side
            else {
                right = mid;
            }
        }

        return nums[left];
    }
}
