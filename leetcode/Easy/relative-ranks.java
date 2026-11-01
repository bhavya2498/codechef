// Problem: Relative Ranks
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/relative-ranks/
// Solved on: 2026-11-01T07:58:35.692Z

import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                answer[arr[i][1]] = "Gold Medal";
            } else if (i == 1) {
                answer[arr[i][1]] = "Silver Medal";
            } else if (i == 2) {
                answer[arr[i][1]] = "Bronze Medal";
            } else {
                answer[arr[i][1]] = String.valueOf(i + 1);
            }
        }

        return answer;
    }
}