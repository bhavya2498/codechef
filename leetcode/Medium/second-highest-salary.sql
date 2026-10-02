// Problem: Second Highest Salary
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: mysql
// Verdict: Accepted
// URL: https://leetcode.com/problems/second-highest-salary/
// Solved on: 2026-10-02T14:06:43.821Z

# Write your MySQL query statement below
SELECT MAX(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee);