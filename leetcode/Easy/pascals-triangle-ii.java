// Problem: Pascal's Triangle II
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/pascals-triangle-ii/
// Solved on: 2026-10-30T16:48:33.717Z

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);

            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }
}