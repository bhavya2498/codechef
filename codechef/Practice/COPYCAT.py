// Problem: COPYCAT
// Platform: codechef
// Language: Python3​
// Verdict: Accepted
// URL: https://www.codechef.com/START263A/problems/COPYCAT
// Solved on: 2026-11-04T15:50:27.113Z

# cook your dish here
import sys

def main():
    data = sys.stdin.read().split()
    t = int(data[0]); p = 1
    out = []
    for _ in range(t):
        n = int(data[p]); s = data[p + 1]; p += 2
        total_zeros = s.count('0')
        best = total_zeros  # k = 0
        ones_pre = 0
        zeros_pre = 0
        for k in range(1, n + 1):
            if s[k - 1] == '1':
                ones_pre += 1
            else:
                zeros_pre += 1
            if k == n:
                valid = s[n - 1] == '0'
            else:
                valid = s[k - 1] == '0' or s[k] == '0'
            if valid:
                cost = ones_pre + (total_zeros - zeros_pre)
                if cost < best:
                    best = cost
        out.append(best)
    print("\n".join(map(str, out)))

main()