// Problem: NCOPIES
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/arrays-new/ARRAYSP01/problems/NCOPIES
// Solved on: 2026-09-23T14:28:16.996Z

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            long M = sc.nextLong();
            String A = sc.next();

            int ones = 0;

            for (int i = 0; i < N; i++) {
                if (A.charAt(i) == '1') {
                    ones++;
                }
            }

            if (ones == 0) {
                System.out.println((long) N * M);
            }
            else if ((ones * M) % 2 != 0) {
                System.out.println(0);
            }
            else if (M % 2 == 0) {
                System.out.println(1);
            }
            else {
                int half = ones / 2;
                int count = 0;
                int current = 0;

                for (int i = 0; i < N; i++) {
                    if (A.charAt(i) == '1') {
                        current++;
                    }

                    if (current == half) {
                        count++;
                    }
                }

                System.out.println(count);
            }
        }
    }
}
