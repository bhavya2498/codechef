// Problem: Intersection of Two Arrays
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/intersection-of-two-arrays/
// Solved on: 2026-10-01T14:13:58.946Z

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}