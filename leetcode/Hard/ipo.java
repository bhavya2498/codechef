// Problem: IPO
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/ipo/
// Solved on: 2026-11-01T07:57:29.390Z


import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // Min-heap: projects ordered by required capital
        PriorityQueue<int[]> minCapital = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Max-heap: available projects ordered by profit
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        int n = profits.length;

        // Store each project's capital requirement and profit
        for (int i = 0; i < n; i++) {
            minCapital.offer(new int[]{capital[i], profits[i]});
        }

        // Choose at most k projects
        for (int i = 0; i < k; i++) {

            // Add all projects we can currently afford
            while (!minCapital.isEmpty() &&
                   minCapital.peek()[0] <= w) {

                maxProfit.offer(minCapital.poll()[1]);
            }

            // No affordable project remains
            if (maxProfit.isEmpty()) {
                break;
            }

            // Select the affordable project with maximum profit
            w += maxProfit.poll();
        }

        return w;
    }
}
