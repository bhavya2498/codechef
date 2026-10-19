// Problem: FLOW006
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/basic-math/BASICMATH/problems/FLOW006
// Solved on: 2026-10-19T16:45:35.904Z


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int sum = 0;

            while (N > 0) {
                int digit = N % 10;
                sum += digit;
                N = N / 10;
            }

            System.out.println(sum);
        }

        sc.close();
    }
}
