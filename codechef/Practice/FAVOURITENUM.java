// Problem: FAVOURITENUM
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/basic-math/BASICMATH/problems/FAVOURITENUM
// Solved on: 2026-10-19T16:46:22.750Z

import java.util.Scanner;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int A = sc.nextInt();

            if (A % 2 == 0 && A % 7 == 0) {
                System.out.println("Alice");
            } else if (A % 2 != 0 && A % 9 == 0) {
                System.out.println("Bob");
            } else {
                System.out.println("Charlie");
            }
        }

        sc.close();
    }
}