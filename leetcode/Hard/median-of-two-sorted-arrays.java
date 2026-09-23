// Problem: Median of Two Sorted Arrays
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/median-of-two-sorted-arrays/
// Solved on: 2026-09-23T14:17:07.310Z

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            nums[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            nums[k++] = nums2[j++];
        }
        int n = nums.length;
        if (n % 2 == 1) {
            return nums[n / 2];
        }
        return (nums[n / 2 - 1] + nums[n / 2]) / 2.0;   
    }
}