// Problem: Find Target Indices After Sorting Array
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-target-indices-after-sorting-array/
// Solved on: 2026-10-19T16:40:16.137Z

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }

        return result;
    }
}