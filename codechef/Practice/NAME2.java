// Problem: NAME2
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/two-pointers-new/TWOPOINT01/problems/NAME2
// Solved on: 2026-10-11T14:20:08.114Z

import java.util.*;
import java.io.*;

class Codechef {
    static boolean check(String a, String b) {
        int i = 0, j = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == a.length();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String m = sc.next();
            String w = sc.next();

            if (check(m, w) || check(w, m)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}