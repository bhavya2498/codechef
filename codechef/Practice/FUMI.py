// Problem: FUMI
// Platform: codechef
// Language: Python3​
// Verdict: Accepted
// URL: https://www.codechef.com/START257D/problems/FUMI
// Solved on: 2026-09-23T16:06:34.741Z

# cook your dish here
T = int(input())

for _ in range(T):
    N, A, B, C = map(int, input().split())

    ans = 10**30

    for d in range(1, N + 1):
        z = (N + d - 1) // d
        cost = (A + B) * d + C * z
        ans = min(ans, cost)

    print(ans)
