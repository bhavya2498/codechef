// Problem: Employees Earning More Than Their Managers
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: mysql
// Verdict: Accepted
// URL: https://leetcode.com/problems/employees-earning-more-than-their-managers/
// Solved on: 2026-10-02T14:07:40.420Z

# Write your MySQL query statement below
SELECT e.name AS Employee
FROM Employee e
JOIN Employee m
ON e.managerId = m.id
WHERE e.salary > m.salary;
