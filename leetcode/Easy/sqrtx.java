// Problem: Sqrt(x)
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/sqrtx/
// Solved on: 2026-10-11T14:13:56.128Z

class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid <= x / (mid == 0 ? 1 : mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}