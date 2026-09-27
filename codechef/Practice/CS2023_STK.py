// Problem: CS2023_STK
// Platform: codechef
// Language: Python3​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/arrays-new/ARRAYSP01/problems/CS2023_STK
// Solved on: 2026-09-27T08:18:33.128Z

T = int(input())

while T > 0:
    N = int(input())

    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    om_streak = 0
    om_max = 0

    for x in A:
        if x > 0:
            om_streak += 1
            om_max = max(om_max, om_streak)
        else:
            om_streak = 0

    addy_streak = 0
    addy_max = 0

    for x in B:
        if x > 0:
            addy_streak += 1
            addy_max = max(addy_max, addy_streak)
        else:
            addy_streak = 0

    if om_max > addy_max:
        print("OM")
    elif addy_max > om_max:
        print("ADDY")
    else:
        print("DRAW")

    T -= 1