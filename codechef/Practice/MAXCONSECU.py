// Problem: MAXCONSECU
// Platform: codechef
// Language: Python3​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/arrays-new/ARRAYSP01/problems/MAXCONSECU
// Solved on: 2026-09-27T08:17:47.569Z

def findMaxConsecutiveOnes(nums):
    count = 0
    maximum = 0
    for num in nums:
        if num == 1:
            count += 1
            maximum = max(maximum, count)
        else:
            count = 0
    return maximum