// Problem: Search a 2D Matrix
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/search-a-2d-matrix/
// Solved on: 2026-10-30T04:08:33.580Z


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert 1D index into 2D coordinates
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }
}
