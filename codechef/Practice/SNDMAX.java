// Problem: SNDMAX
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/basic-math/BASICMATH/problems/SNDMAX
// Solved on: 2026-10-16T15:04:20.428Z


import java.util.Scanner;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        while (N-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if ((a > b && a < c) || (a < b && a > c)) {
                System.out.println(a);
            } else if ((b > a && b < c) || (b < a && b > c)) {
                System.out.println(b);
            } else {
                System.out.println(c);
            }
        }

        sc.close();
    }
}
