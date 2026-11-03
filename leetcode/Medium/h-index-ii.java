// Problem: H-Index II
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/h-index-ii/
// Solved on: 2026-11-03T17:21:01.949Z


class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int papers = n - mid;

            if (citations[mid] == papers) {
                return papers;
            }
            else if (citations[mid] < papers) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return n - left;
    }
}
