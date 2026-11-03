// Problem: Number of Boomerangs
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/number-of-boomerangs/
// Solved on: 2026-11-03T17:39:30.161Z


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {

        int result = 0;

        // Try every point as the center
        for (int i = 0; i < points.length; i++) {

            Map<Integer, Integer> map = new HashMap<>();

            // Calculate distance from center to every other point
            for (int j = 0; j < points.length; j++) {

                if (i == j) {
                    continue;
                }

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                int distance = dx * dx + dy * dy;

                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            // Count possible ordered pairs
            for (int count : map.values()) {
                result += count * (count - 1);
            }
        }

        return result;
    }
}
