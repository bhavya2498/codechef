// Problem: DSAPROB16
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/two-pointers-new/TWOPOINT01/problems/DSAPROB16
// Solved on: 2026-10-11T14:21:13.787Z

import java.util.*;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] result = new int[n];
        int k = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (a[i] % 2 != 0) {
                result[k++] = a[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                result[k++] = a[i];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}