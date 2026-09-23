// Problem: Remove Element
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/remove-element/
// Solved on: 2026-09-23T14:13:39.348Z

class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;

        
    }
}