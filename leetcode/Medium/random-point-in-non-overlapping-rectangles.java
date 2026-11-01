// Problem: Random Point in Non-overlapping Rectangles
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
// Solved on: 2026-11-01T07:56:15.173Z

import java.util.*;

class Solution {
    int[][] rects;
    long[] prefix;
    long total;
    Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        int n = rects.length;

        prefix = new long[n];
        total = 0;
        random = new Random();

        for (int i = 0; i < n; i++) {
            long width = rects[i][2] - rects[i][0] + 1;
            long height = rects[i][3] - rects[i][1] + 1;

            total += width * height;
            prefix[i] = total;
        }
    }

    public int[] pick() {
        // Pick a random integer from 1 to total
        long target = random.nextLong(total) + 1;

        // Find the rectangle containing this random position
        int left = 0, right = prefix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int[] rect = rects[left];

        // Generate a random integer point inside the rectangle
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);

        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */