// Problem: RATINGINPRAC
// Platform: codechef
// Language: Python3​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/arrays-new/ARRAYSP01/problems/RATINGINPRAC
// Solved on: 2026-09-27T08:15:31.912Z

t = int(input())
while t > 0:
    n = int(input())
    d = list(map(int, input().split()))
    possible = True
    for i in range(n - 1):
        if d[i] > d[i + 1]:
            possible = False
            break
    if possible:
        print("Yes")
    else:
        print("No")
    t -= 1
