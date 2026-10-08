// Problem: SQLPBP05
// Platform: codechef
// Language: ┌──────────┬──────────┬──────────┬────────┬────────────┬───────┐
│ match_id │ player_1 │ player_2 │ winner │ match_date │ score │
├──────────┼──────────┼──────────┼────────┼────────────┼───────┤
│ 106      │ Frank    │ Hank     │ Frank  │ 2024-01-29 │ 1450  │
│ 101      │ Alice    │ Bob      │ Bob    │ 2024-01-25 │ 1500  │
│ 110      │ David    │ Eve      │ David  │ 2024-01-24 │ 1600  │
│ 108      │ Jack     │ Alice    │ Jack   │ 2024-01-19 │ 1400  │
│ 103      │ Eve      │ Bob      │ Bob    │ 2024-01-17 │ 1500  │
└──────────┴──────────┴──────────┴────────┴────────────┴───────┘
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/sql-case-studies-topic-wise/SQLBP01/problems/SQLPBP05
// Solved on: 2026-10-08T03:07:57.963Z

SELECT
    m.match_id,
    p1.player_name AS player_1,
    p2.player_name AS player_2,
    w.player_name AS winner,
    m.match_date,
    w.score
FROM Matches m
JOIN Players p1
    ON m.player_1 = p1.player_name
JOIN Players p2
    ON m.player_2 = p2.player_name
JOIN Players w
    ON m.winner = w.player_name
ORDER BY m.match_date DESC
LIMIT 5;