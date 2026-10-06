// Problem: License Key Formatting
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/license-key-formatting/
// Solved on: 2026-10-06T14:32:46.296Z

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != '-') {
                str.append(Character.toUpperCase(c));
            }
        }

        StringBuilder result = new StringBuilder();
        int first = str.length() % k;
        int i = 0;

        if (first > 0) {
            result.append(str.substring(0, first));
            i = first;
        }

        while (i < str.length()) {
            if (result.length() > 0) {
                result.append("-");
            }
            result.append(str.substring(i, Math.min(i + k, str.length())));
            i += k;
        }

        return result.toString();
    }
}
