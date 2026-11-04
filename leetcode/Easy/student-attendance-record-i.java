// Problem: Student Attendance Record I
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/student-attendance-record-i/
// Solved on: 2026-11-04T04:48:24.927Z


class Solution {
    public boolean checkRecord(String s) {

        int absent = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'A') {
                absent++;
            }

            if (absent >= 2) {
                return false;
            }

            if (i >= 2 &&
                s.charAt(i) == 'L' &&
                s.charAt(i - 1) == 'L' &&
                s.charAt(i - 2) == 'L') {
                return false;
            }
        }

        return true;
    }
}
