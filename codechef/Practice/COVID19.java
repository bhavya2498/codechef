// Problem: COVID19
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/two-pointers-new/TWOPOINT01/problems/COVID19
// Solved on: 2026-10-12T13:10:32.642Z


import java.util.*;

class CodeChef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int[] X = new int[N];

            for (int i = 0; i < N; i++) {
                X[i] = sc.nextInt();
            }

            int min = N;
            int max = 1;
            int count = 1;

            for (int i = 1; i < N; i++) {
                if (X[i] - X[i - 1] <= 2) {
                    count++;
                } else {
                    min = Math.min(min, count);
                    max = Math.max(max, count);
                    count = 1;
                }
            }

            min = Math.min(min, count);
            max = Math.max(max, count);

            System.out.println(min + " " + max);
        }

        sc.close();
    }
}

