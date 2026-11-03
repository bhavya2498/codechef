// Problem: Random Pick Index
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/random-pick-index/
// Solved on: 2026-11-03T17:29:31.897Z


import java.util.Random;

class Solution {

    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {

        int count = 0;
        int result = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {

                count++;

                if (random.nextInt(count) == 0) {
                    result = i;
                }
            }
        }

        return result;
    }
}
