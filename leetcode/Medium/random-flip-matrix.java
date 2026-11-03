// Problem: Random Flip Matrix
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/random-flip-matrix/
// Solved on: 2026-11-03T17:50:12.442Z


import java.util.*;

class Solution {

    private int rows;
    private int cols;
    private int remaining;

    private Random random;
    private Map<Integer, Integer> map;

    public Solution(int m, int n) {
        rows = m;
        cols = n;

        remaining = m * n;

        random = new Random();
        map = new HashMap<>();
    }

    public int[] flip() {

        // Pick a random available index
        int randomIndex = random.nextInt(remaining);

        // Find its actual mapped index
        int index = map.getOrDefault(randomIndex, randomIndex);

        // Get the last available index
        int lastIndex = remaining - 1;

        int lastValue = map.getOrDefault(lastIndex, lastIndex);

        // Replace the selected position with the last value
        map.put(randomIndex, lastValue);

        // Remove the last position from consideration
        map.remove(lastIndex);

        remaining--;

        // Convert 1D index into 2D coordinates
        return new int[] {
            index / cols,
            index % cols
        };
    }

    public void reset() {
        map.clear();
        remaining = rows * cols;
    }
}
