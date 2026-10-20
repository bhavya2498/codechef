// Problem: Sum of Sortable Integers
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/sum-of-sortable-integers/
// Solved on: 2026-10-20T06:18:23.305Z

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        long ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;
            int previousLast = Integer.MIN_VALUE;

            for (int start = 0; start < n && valid; start += k) {
                int end = start + k;
                int drops = 0;
                int dropIndex = -1;

                for (int i = start; i < end - 1; i++) {
                    if (nums[i] > nums[i + 1]) {
                        drops++;
                        dropIndex = i;
                    }
                }

                if (drops > 1) {
                    valid = false;
                    break;
                }

                int first;
                int last;

                if (drops == 0) {
                    first = nums[start];
                    last = nums[end - 1];
                } else {
                    if (nums[end - 1] > nums[start]) {
                        valid = false;
                        break;
                    }

                    first = nums[dropIndex + 1];
                    last = nums[dropIndex];
                }

                if (first < previousLast) {
                    valid = false;
                    break;
                }

                previousLast = last;
            }

            if (valid) ans += k;
        }

        return (int) ans;
    }
}