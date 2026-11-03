// Problem: Sort Characters By Frequency
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/sort-characters-by-frequency/
// Solved on: 2026-11-03T17:42:19.891Z


import java.util.*;

class Solution {
    public String frequencySort(String s) {

        // Step 1: Count frequency of each character
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Convert characters into a list
        List<Character> list = new ArrayList<>(map.keySet());

        // Step 3: Sort by frequency in descending order
        list.sort((a, b) -> map.get(b) - map.get(a));

        // Step 4: Build the result
        StringBuilder result = new StringBuilder();

        for (char ch : list) {
            int count = map.get(ch);

            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
