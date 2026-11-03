// Problem: Rank Transform of an Array
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/rank-transform-of-an-array/
// Solved on: 2026-11-03T07:44:58.417Z


import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();

        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }

        return result;
    }
}
