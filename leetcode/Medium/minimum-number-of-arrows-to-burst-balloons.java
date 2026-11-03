// Problem: Minimum Number of Arrows to Burst Balloons
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
// Solved on: 2026-11-03T17:43:15.982Z


import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {

        // Sort balloons by their ending coordinate
        Arrays.sort(points, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        // At least one arrow is needed
        int arrows = 1;

        // Position of the first arrow
        int arrowPosition = points[0][1];

        // Check remaining balloons
        for (int i = 1; i < points.length; i++) {

            // If the balloon starts after the arrow,
            // it cannot be burst by the current arrow
            if (points[i][0] > arrowPosition) {

                arrows++;

                // Shoot a new arrow at this balloon's end
                arrowPosition = points[i][1];
            }
        }

        return arrows;
    }
}
