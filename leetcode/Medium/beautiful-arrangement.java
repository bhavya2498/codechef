// Problem: Beautiful Arrangement
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/beautiful-arrangement/
// Solved on: 2026-11-03T17:52:35.885Z


class Solution {
    int count = 0;

    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];

        backtrack(1, n, used);

        return count;
    }

    private void backtrack(int position, int n, boolean[] used) {

        if (position > n) {
            count++;
            return;
        }

        for (int num = 1; num <= n; num++) {

            if (!used[num] &&
                (num % position == 0 || position % num == 0)) {

                used[num] = true;

                backtrack(position + 1, n, used);

                used[num] = false;
            }
        }
    }
}
