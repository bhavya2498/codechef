// Problem: DSCPPAS266
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/sorting-new/SORTING01/problems/DSCPPAS266
// Solved on: 2026-10-05T12:47:54.794Z

public static boolean canReduce(int N, int[] arr) {

    java.util.Arrays.sort(arr);

    for (int i = 1; i < N; i++) {

        if (arr[i] - arr[i - 1] > 1) {
            return false;
        }
    }

    return true;
}