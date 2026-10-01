// Problem: HORSES
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/sorting-new/SORTING01/problems/HORSES
// Solved on: 2026-10-01T14:19:38.207Z

import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int N = sc.nextInt();

            long[] skills = new long[N];

            for (int i = 0; i < N; i++) {
                skills[i] = sc.nextLong();
            }

            Arrays.sort(skills);

            long minDifference = Long.MAX_VALUE;

            for (int i = 1; i < N; i++) {
                long difference = skills[i] - skills[i - 1];

                minDifference = Math.min(minDifference, difference);
            }

            System.out.println(minDifference);
        }

        sc.close();
    }
}