// Problem: COMPRESSVD
// Platform: codechef
// Language: Python3​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/arrays-new/ARRAYSP01/problems/COMPRESSVD
// Solved on: 2026-09-27T08:14:11.393Z

# cook your dish here
T = int(input())
for _ in range(T):
    N = int(input())
    A = list(map(int, input().split()))
    count = 1
    for i in range(1, N):
        if A[i] != A[i - 1]:
            count += 1
    print(count)
