// Problem: Construct the Rectangle
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/construct-the-rectangle/
// Solved on: 2026-11-01T07:53:35.421Z

class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);

        while (area % w != 0) {
            w--;
        }

        int l = area / w;

        return new int[]{l, w};
    }
}