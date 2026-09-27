// Problem: SQUIDRULE
// Platform: codechef
// Language: Python3​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/arrays-new/ARRAYSP01/problems/SQUIDRULE
// Solved on: 2026-09-27T08:16:15.138Z

# cook your dish here
t = int(input())
while t > 0:
    n = int(input())
    a = list(map(int, input().split()))
    total = sum(a)
    minimum = min(a)
    print(total - minimum)
    t -= 1
