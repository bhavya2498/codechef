// Problem: CANDYSTORE
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/basic-math/BASICMATH/problems/CANDYSTORE
// Solved on: 2026-10-18T16:54:53.192Z


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            int amount;

            if (Y <= X) {
                amount = Y;
            } else {
                amount = X + (Y - X) * 2;
            }

            System.out.println(amount);
        }

        sc.close();
    }
}
