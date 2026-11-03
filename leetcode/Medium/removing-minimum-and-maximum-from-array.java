// Problem: Removing Minimum and Maximum From Array
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
// Solved on: 2026-11-03T03:39:12.665Z


class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }

            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        int front = right + 1;
        int back = n - left;
        int both = (left + 1) + (n - right);

        return Math.min(front, Math.min(back, both));
    }
}
