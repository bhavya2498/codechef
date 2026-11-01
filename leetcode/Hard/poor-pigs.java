// Problem: Poor Pigs
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/poor-pigs/
// Solved on: 2026-11-01T06:30:13.675Z


class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int states = minutesToTest / minutesToDie + 1;

        int pigs = 0;
        int capacity = 1;

        while (capacity < buckets) {
            capacity *= states;
            pigs++;
        }

        return pigs;
    }
}
