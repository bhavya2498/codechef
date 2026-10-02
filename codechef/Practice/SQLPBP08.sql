// Problem: SQLPBP08
// Platform: codechef
// Language: SQL​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/sql-case-studies-topic-wise/SQLBP01/problems/SQLPBP08
// Solved on: 2026-10-02T14:15:41.164Z

SELECT  employee_name, company,salary FROM Employees
WHERE category ='Full-Time'
ORDER BY salary DESC;