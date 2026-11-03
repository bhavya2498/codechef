// Problem: Minimum Time Difference
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-time-difference/
// Solved on: 2026-11-03T17:56:43.966Z


import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {

        List<Integer> minutes = new ArrayList<>();

        // Convert every time into minutes
        for (String time : timePoints) {

            int hours = Integer.parseInt(time.substring(0, 2));
            int mins = Integer.parseInt(time.substring(3, 5));

            int total = hours * 60 + mins;

            minutes.add(total);
        }

        // Sort the converted times
        Collections.sort(minutes);

        int minDiff = Integer.MAX_VALUE;

        // Compare adjacent times
        for (int i = 1; i < minutes.size(); i++) {

            int diff = minutes.get(i) - minutes.get(i - 1);

            minDiff = Math.min(minDiff, diff);
        }

        // Compare across midnight
        int circularDiff = 1440 - minutes.get(minutes.size() - 1)
                                + minutes.get(0);

        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }
}
