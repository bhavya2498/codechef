// Problem: SIMPSTAT
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/sorting-new/SORTING01/problems/SIMPSTAT
// Solved on: 2026-10-01T14:19:05.908Z

import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            long sum = 0;

            for (int i = K; i < N - K; i++) {
                sum += arr[i];
            }

            double average = (double) sum / (N - 2 * K);

            System.out.printf("%.6f%n", average);
        }

        sc.close();
    }
}