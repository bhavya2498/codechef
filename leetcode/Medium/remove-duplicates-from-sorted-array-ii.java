// Problem: Remove Duplicates from Sorted Array II
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// Solved on: 2026-10-12T13:06:41.101Z


class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;

        for (int num : nums) {
            if (k < 2 || num != nums[k - 2]) {
                nums[k] = num;
                k++;
            }
        }

        return k;
    }
}
