// Problem: String Compression
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/string-compression/
// Solved on: 2026-11-03T17:37:47.898Z


class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char current = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            chars[write++] = current;

            if (count > 1) {
                String num = String.valueOf(count);

                for (char c : num.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
