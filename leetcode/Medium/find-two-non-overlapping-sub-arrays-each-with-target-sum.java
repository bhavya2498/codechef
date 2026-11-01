// Problem: Find Two Non-overlapping Sub-arrays Each With Target Sum
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
// Solved on: 2026-11-01T14:55:53.349Z


class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // Store the minimum subarray length found so far
            if (right > 0) {
                best[right] = best[right - 1];
            }

            if (sum == target) {
                int len = right - left + 1;

                // Combine with a previous non-overlapping subarray
                if (left > 0 && best[left - 1] != 0) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                minLen = Math.min(minLen, len);
            }

            // Update best subarray length up to right
            if (minLen != Integer.MAX_VALUE) {
                best[right] = minLen;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
