// Problem: Intersection of Two Arrays II
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/intersection-of-two-arrays-ii/
// Solved on: 2026-10-01T14:14:35.545Z

import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Check nums2
        for (int num : nums2) {

            if (map.getOrDefault(num, 0) > 0) {

                list.add(num);

                map.put(num, map.get(num) - 1);
            }
        }

        // Convert ArrayList to int[]
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}