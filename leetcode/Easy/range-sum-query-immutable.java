// Problem: Range Sum Query - Immutable
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/range-sum-query-immutable/
// Solved on: 2026-11-03T15:56:01.055Z


class NumArray {

    int[] prefix;

    public NumArray(int[] nums) {

        prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        return prefix[right + 1] - prefix[left];
    }
}
