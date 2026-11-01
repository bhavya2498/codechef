// Problem: Assign Cookies
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/assign-cookies/
// Solved on: 2026-11-01T06:26:23.231Z


import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // Child pointer
        int j = 0; // Cookie pointer

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                // Cookie satisfies this child
                i++;
            }

            // Move to the next cookie
            j++;
        }

        return i;
    }
}
