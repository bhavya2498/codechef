// Problem: Guess Number Higher or Lower
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/guess-number-higher-or-lower/
// Solved on: 2026-10-30T17:18:46.202Z


public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid;
            } 
            else if (result == -1) {
                // Our guess is too high
                right = mid - 1;
            } 
            else {
                // Our guess is too low
                left = mid + 1;
            }
        }

        return -1;
    }
}
