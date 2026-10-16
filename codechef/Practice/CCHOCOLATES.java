// Problem: CCHOCOLATES
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/basic-math/BASICMATH/problems/CCHOCOLATES
// Solved on: 2026-10-16T15:05:43.380Z


import java.util.Scanner;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();

            int totalMoney = (X * 5) + (Y * 10);
            int chocolates = totalMoney / Z;

            System.out.println(chocolates);
        }

        sc.close();
    }
}
