// Problem: DOLL
// Platform: codechef
// Language: Python3​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/arrays-new/ARRAYSP01/problems/DOLL
// Solved on: 2026-09-27T08:13:41.540Z

# cook your dish here
T = int(input())

for _ in range(T):
    N, K = map(int, input().split())
    H = list(map(int, input().split()))
    count = 0
    for height in H:
        if height > K:
            count += 1
    print(count)
