// Problem: Non-overlapping Intervals
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/non-overlapping-intervals/
// Solved on: 2026-11-01T06:20:55.415Z


import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort intervals by their ending time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Overlap found
            if (intervals[i][0] < prevEnd) {
                removals++;
            } 
            // No overlap: keep this interval
            else {
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}
