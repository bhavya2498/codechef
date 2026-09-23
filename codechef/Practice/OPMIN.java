// Problem: OPMIN
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/arrays-new/ARRAYSP01/problems/OPMIN
// Solved on: 2026-09-23T14:27:12.198Z

class Solution {
    public int countNonMinimum(int[] nums) {
         int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        // Count elements greater than minimum
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                count++;
            }
        }

        return count;
        
    }
}
