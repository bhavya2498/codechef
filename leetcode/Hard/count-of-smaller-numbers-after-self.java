// Problem: Count of Smaller Numbers After Self
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/count-of-smaller-numbers-after-self/
// Solved on: 2026-11-03T16:01:27.124Z


import java.util.*;

class Solution {

    int[] count;
    int[] indexes;
    int[] temp;

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        count = new int[n];
        indexes = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, 0, n - 1);

        List<Integer> result = new ArrayList<>();

        for (int x : count) {
            result.add(x);
        }

        return result;
    }

    private void mergeSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        int k = left;

        int rightCount = 0;

        while (i <= mid && j <= right) {

            if (nums[indexes[j]] < nums[indexes[i]]) {

                temp[k++] = indexes[j++];
                rightCount++;

            } else {

                count[indexes[i]] += rightCount;
                temp[k++] = indexes[i++];
            }
        }

        while (i <= mid) {

            count[indexes[i]] += rightCount;
            temp[k++] = indexes[i++];
        }

        while (j <= right) {
            temp[k++] = indexes[j++];
        }

        for (int p = left; p <= right; p++) {
            indexes[p] = temp[p];
        }
    }
}
