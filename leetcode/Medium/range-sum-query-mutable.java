// Problem: Range Sum Query - Mutable
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/range-sum-query-mutable/
// Solved on: 2026-11-03T15:58:00.869Z


class NumArray {
    int[] nums;
    int[] bit;
    int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums.clone();
        this.bit = new int[n + 1];

        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    // Add a value to the Fenwick Tree
    private void add(int index, int value) {
        while (index <= n) {
            bit[index] += value;
            index += index & -index;
        }
    }

    // Get prefix sum from index 1 to index
    private int prefixSum(int index) {
        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }

        return sum;
    }

    public void update(int index, int val) {
        int difference = val - nums[index];

        nums[index] = val;
        add(index + 1, difference);
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }
}
