// Problem: Best Time to Buy and Sell Stock with Cooldown
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
// Solved on: 2026-11-03T15:58:43.053Z


class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prevHold, prevRest - prices[i]);

            sold = prevHold + prices[i];

            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(sold, rest);
    }
}
