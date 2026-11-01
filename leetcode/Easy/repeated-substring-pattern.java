// Problem: Repeated Substring Pattern
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/repeated-substring-pattern/
// Solved on: 2026-11-01T06:32:01.300Z


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        
        String result = doubled.substring(1, doubled.length() - 1);
        
        return result.contains(s);
    }
}
