// Problem: Heaters
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/heaters/
// Solved on: 2026-11-03T17:46:36.626Z


import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);

        int answer = 0;

        for (int house : houses) {

            int left = 0;
            int right = heaters.length - 1;

            // Find the first heater >= house
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (heaters[mid] < house) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // Distance to the heater on the right
            int rightDistance = Integer.MAX_VALUE;
            if (left < heaters.length) {
                rightDistance = heaters[left] - house;
            }

            // Distance to the heater on the left
            int leftDistance = Integer.MAX_VALUE;
            if (right >= 0) {
                leftDistance = house - heaters[right];
            }

            // Choose the nearest heater
            int nearestDistance = Math.min(
                leftDistance, rightDistance
            );

            answer = Math.max(answer, nearestDistance);
        }

        return answer;
    }
}
