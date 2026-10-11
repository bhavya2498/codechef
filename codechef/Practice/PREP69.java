// Problem: PREP69
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/two-pointers-new/TWOPOINT01/problems/PREP69
// Solved on: 2026-10-11T14:19:29.731Z

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int j = 0;

            for (int i = 1; i < n; i++) {
                if (a[i] != a[j]) {
                    j++;
                    a[j] = a[i];
                }
            }

            System.out.println(j + 1);

            for (int i = 0; i <= j; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}